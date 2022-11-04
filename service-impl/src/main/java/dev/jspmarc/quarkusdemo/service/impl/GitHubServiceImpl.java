package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.service.api.GitHubService;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class GitHubServiceImpl implements GitHubService {

  @Override
  public List<GitHubUserResponse> getRandomUsers() {
    var githubResponse = GitHubUserResponse.builder()
        .gitHubId(420669)
        .gitHubLogin("jspmarc")
        .build();

    return Collections.singletonList(githubResponse);
  }
}
