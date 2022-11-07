package dev.jspmarc.quarkusdemo.entity.dao.common;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseMongo {

  @BsonId
  @BsonProperty("_id")
  private ObjectId id;
  private Long version = 1L;
  private Date createdDate = new Date();
  private String createdBy = "SYSTEM";
  private Date updatedDate = new Date();
  private String updatedBy = "SYSTEM";
  private Integer isDeleted = 0;
}
