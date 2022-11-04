package dev.jspmarc.quarkusdemo.rest.web.controller;

import dev.jspmarc.quarkusdemo.service.api.GitHubService;
import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(ApiPath.BASE_GITHUB_PATH)
public class GitHubController {

  @Inject
  GitHubService gitHubService;

  @GET
  @Path(ApiPath.GITHUB_USERS)
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<List<GitHubUserResponse>> getRandomUsers() {
    return gitHubService.getRandomUsers();
  }
}
