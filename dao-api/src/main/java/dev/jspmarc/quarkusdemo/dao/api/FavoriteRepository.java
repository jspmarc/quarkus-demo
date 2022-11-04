package dev.jspmarc.quarkusdemo.dao.api;

import dev.jspmarc.springdemo.entity.dao.Favorite;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface FavoriteRepository {

  Multi<Favorite> findAll();

  Uni<Favorite> saveNew(Favorite favorite);
}
