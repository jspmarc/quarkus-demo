package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.dao.api.FavoriteRepository;
import dev.jspmarc.quarkusdemo.service.api.FavoriteService;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FavoriteServiceImpl implements FavoriteService {

  @Inject
  FavoriteRepository favoriteRepository;

  @Override
  public Multi<FavoriteResponse> getAll() {
    return favoriteRepository.findAll().map(favorite -> FavoriteResponse.builder()
        .id(favorite.getId())
        .gitHubLogin(favorite.getGitHubLogin())
        .gitHubId(favorite.getGitHubId())
        .build());
  }

  @Override
  public Uni<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest) {
    return favoriteRepository.saveNew(Favorite.builder()
            .gitHubLogin(favoriteRequest.getGitHubLogin())
            .gitHubId(favoriteRequest.getGitHubId())
            .build())
        .map(favorite -> FavoriteResponse.builder()
            .id(favorite.getId())
            .gitHubId(favorite.getGitHubId())
            .gitHubLogin(favorite.getGitHubLogin())
            .build());
  }
}
