package dev.jspmarc.quarkusdemo.outbound.api;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/")
@RegisterRestClient(configKey = "github")
public interface GitHubEndpointService {

  @GET
  @Path(ApiPath.GITHUB_USERS)
  @Produces(MediaType.APPLICATION_JSON)
  Uni<List<GitHubUser>> getUsers(@RestQuery int since, @QueryParam("per_page") int perPage);
}
