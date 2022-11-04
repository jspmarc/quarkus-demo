package dev.jspmarc.quarkusdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import java.util.List;

public interface FavoriteInterface {

  List<FavoriteResponse> getAll();
  FavoriteResponse addToFavorite(FavoriteRequest favoriteRequest);
}
