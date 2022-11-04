package dev.jspmarc.quarkusdemo.dao.impl;

import dev.jspmarc.quarkusdemo.dao.api.FavoriteRepository;
import dev.jspmarc.quarkusdemo.libraries.dao.BaseRepository;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import org.bson.Document;

@ApplicationScoped
public class FavoriteRepositoryImpl extends BaseRepository implements FavoriteRepository {

  public Multi<Favorite> findAll() {
    return getCollection().find()
        .map(document -> Favorite.builder()
            .id(document.getObjectId("_id").toString())
            .gitHubId(document.getInteger("gitHubId"))
            .gitHubLogin(document.getString("gitHubLogin"))
            .createdBy(document.getString("createdBy"))
            .createdDate(document.getDate("createdDate"))
            .updatedBy(document.getString("updatedBy"))
            .updatedDate(document.getDate("updatedDate"))
            .version(document.getLong("version"))
            .build());
  }

  public Uni<Favorite> saveNew(Favorite favorite) {
    favorite.setCreatedBy("SYSTEM");
    favorite.setCreatedDate(new Date());
    favorite.setUpdatedBy("SYSTEM");
    favorite.setUpdatedDate(new Date());
    favorite.setVersion(1L);
    Document document = new Document()
        .append("gitHubId", favorite.getGitHubId())
        .append("gitHubLogin", favorite.getGitHubLogin())
        .append("createdBy", favorite.getCreatedBy())
        .append("createdDate", favorite.getCreatedDate())
        .append("updatedBy", favorite.getUpdatedBy())
        .append("updatedDate", favorite.getUpdatedDate())
        .append("version", favorite.getVersion());

    return getCollection().insertOne(document).map(i -> {
      favorite.setId(i.getInsertedId().asObjectId().getValue().toString());
      return favorite;
    });
  }

  private ReactiveMongoCollection<Document> getCollection() {
    return this.getCollection("favorite");
  }
}
