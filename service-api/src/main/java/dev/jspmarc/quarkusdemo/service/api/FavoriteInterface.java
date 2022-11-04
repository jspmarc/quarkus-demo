package dev.jspmarc.quarkusdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface FavoriteInterface {

  Multi<FavoriteResponse> getAll();
  Uni<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest);
}
