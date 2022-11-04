package dev.jspmarc.quarkusdemo.outbound.impl;

import dev.jspmarc.quarkusdemo.outbound.api.GitHubEndpointService;
import dev.jspmarc.quarkusdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class GitHubOutboundServiceImpl implements GitHubOutboundService {

  @RestClient
  GitHubEndpointService gitHubEndpointService;

  @Override
  public Uni<List<GitHubUserResponse>> getRandomUsers(int since) {
    var response = gitHubEndpointService.getUsers(since, GitHubServiceConstant.RESULT_COUNT);

    return response.map(gitHubUsers ->
        gitHubUsers.stream()
            .map(user -> GitHubUserResponse.builder()
                .gitHubLogin(user.getLogin())
                .gitHubId(user.getId())
                .build())
            .collect(Collectors.toList())
    );
  }
}
