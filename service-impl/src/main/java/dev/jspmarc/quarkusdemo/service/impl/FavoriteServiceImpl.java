package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.dao.FavoriteRepository;
import dev.jspmarc.quarkusdemo.entity.dao.Favorite;
import dev.jspmarc.quarkusdemo.service.api.FavoriteService;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.smallrye.mutiny.Uni;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.types.ObjectId;

@ApplicationScoped
public class FavoriteServiceImpl implements FavoriteService {

  @Inject
  FavoriteRepository favoriteRepository;

  @Override
  public Uni<List<FavoriteResponse>> getAll() {
    Uni<List<Favorite>> favorites = favoriteRepository.listAll();

    return favorites.map(list -> list.stream().map(favorite -> FavoriteResponse.builder()
        .id(favorite.getId().toString())
        .gitHubId(favorite.getGitHubId())
        .gitHubLogin(favorite.getGitHubLogin())
        .build()).toList());
  }

  @Override
  public Uni<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest) {
    var favorite = Favorite.builder()
        .id(ObjectId.get())
        .gitHubId(favoriteRequest.getGitHubId())
        .gitHubLogin(favoriteRequest.getGitHubLogin())
        .createdBy("SYSTEM")
        .createdDate(new Date())
        .updatedBy("SYSTEM")
        .updatedDate(new Date())
        .version(1L)
        .build();
    Uni<Favorite> saving = favoriteRepository.persist(favorite);
    return saving.map(saved -> FavoriteResponse.builder()
        .gitHubLogin(saved.getGitHubLogin())
        .gitHubId(saved.getGitHubId())
        .id(saved.getId().toString())
        .build());
  }
}
