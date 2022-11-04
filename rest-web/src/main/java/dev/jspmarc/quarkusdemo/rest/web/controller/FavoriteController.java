package dev.jspmarc.quarkusdemo.rest.web.controller;

import dev.jspmarc.quarkusdemo.service.api.FavoriteService;
import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path(ApiPath.BASE_FAVORITE_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class FavoriteController {

  @Inject
  FavoriteService favoriteService;

  @GET
  public Multi<FavoriteResponse> getAll() {
    return favoriteService.getAll();
  }

  @POST
  @ResponseStatus(201)
  @Consumes(MediaType.APPLICATION_JSON)
  public Uni<FavoriteResponse> create(FavoriteRequest favoriteRequest) {
    return favoriteService.addToFavorite(favoriteRequest);
  }
}
