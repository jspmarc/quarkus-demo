package dev.jspmarc.quarkusdemo.dao;

import dev.jspmarc.quarkusdemo.entity.dao.Favorite;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FavoriteRepository implements ReactivePanacheMongoRepository<Favorite> {

}
