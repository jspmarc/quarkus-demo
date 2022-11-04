package dev.jspmarc.quarkusdemo.dao;

import dev.jspmarc.quarkusdemo.dao.common.BaseMongo;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.smallrye.mutiny.Uni;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(collection = "favorite")
public class Favorite extends BaseMongo {

  private int gitHubId;
  private String gitHubLogin;

  @Builder
  public Favorite(Long version, Date createdDate, String createdBy,
      Date updatedDate, String updatedBy, Integer isDeleted, int gitHubId,
      String gitHubLogin) {
    super(version, createdDate, createdBy, updatedDate, updatedBy, isDeleted);
    this.gitHubId = gitHubId;
    this.gitHubLogin = gitHubLogin;
  }

  public Uni<Favorite> save() {
    return this.persist();
  }
}
