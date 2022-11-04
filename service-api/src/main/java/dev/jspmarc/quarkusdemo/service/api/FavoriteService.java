package dev.jspmarc.quarkusdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface FavoriteService {

  Uni<List<FavoriteResponse>> getAll();
  Uni<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest);
}
