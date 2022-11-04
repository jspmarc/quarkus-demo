package dev.jspmarc.quarkusdemo.dao.common;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseMongo extends ReactivePanacheMongoEntity {

  private Long version = 1L;
  private Date createdDate = new Date();
  private String createdBy = "SYSTEM";
  private Date updatedDate = new Date();
  private String updatedBy = "SYSTEM";
  private Integer isDeleted = 0;
}
