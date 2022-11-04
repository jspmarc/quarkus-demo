package dev.jspmarc.quarkusdemo.libraries.dao;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import javax.inject.Inject;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class BaseRepository {

  @ConfigProperty(name = "quarkus.mongodb.database")
  String databaseName;

  @Inject
  ReactiveMongoClient mongoClient;

  protected ReactiveMongoCollection<Document> getCollection(String collectionName) {
    return mongoClient.getDatabase(databaseName).getCollection(collectionName);
  }
}
