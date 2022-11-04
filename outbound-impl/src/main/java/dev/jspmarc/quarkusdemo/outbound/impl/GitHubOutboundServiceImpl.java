package dev.jspmarc.quarkusdemo.outbound.impl;

import dev.jspmarc.quarkusdemo.outbound.api.GitHubEndpointService;
import dev.jspmarc.quarkusdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class GitHubOutboundServiceImpl implements GitHubOutboundService {

  @RestClient
  GitHubEndpointService gitHubEndpointService;

  @Override
  public List<GitHubUserResponse> getRandomUsers(int since) {
    List<GitHubUser> response = gitHubEndpointService.getUsers(since,
        GitHubServiceConstant.RESULT_COUNT);

    return response.stream()
        .map(user -> GitHubUserResponse.builder()
            .gitHubLogin(user.getLogin())
            .gitHubId(user.getId())
            .build())
        .collect(Collectors.toList());
  }
}
