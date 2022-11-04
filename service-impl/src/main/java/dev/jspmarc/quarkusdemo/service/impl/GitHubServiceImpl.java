package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.quarkusdemo.service.api.GitHubService;
import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class GitHubServiceImpl implements GitHubService {

  public static final Random random = new Random();

  @Inject
  GitHubOutboundService gitHubOutboundService;

  @Override
  public List<GitHubUserResponse> getRandomUsers() {
    int since = random.nextInt(GitHubServiceConstant.MAX_USER_ID);
    return gitHubOutboundService.getRandomUsers(since);
  }
}
