package dev.jspmarc.quarkusdemo.entity.dao;

import dev.jspmarc.quarkusdemo.entity.dao.common.BaseMongo;
import io.quarkus.mongodb.panache.common.MongoEntity;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(collection = "favorite")
public class Favorite extends BaseMongo {

  private int gitHubId;
  private String gitHubLogin;

  @Builder
  public Favorite(ObjectId id, Long version, Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, Integer isDeleted, int gitHubId, String gitHubLogin) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted);
    this.gitHubId = gitHubId;
    this.gitHubLogin = gitHubLogin;
  }
}
