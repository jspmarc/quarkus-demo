package dev.jspmarc.quarkusdemo.outbound.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface GitHubOutboundService {

  Uni<List<GitHubUserResponse>> getRandomUsers(int since);
}
