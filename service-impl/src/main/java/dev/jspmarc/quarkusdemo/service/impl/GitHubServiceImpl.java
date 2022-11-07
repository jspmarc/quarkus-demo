package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.quarkusdemo.service.api.GitHubService;
import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class GitHubServiceImpl implements GitHubService {

  @Inject
  GitHubOutboundService gitHubOutboundService;

  @Override
  public Uni<List<GitHubUserResponse>> getRandomUsers() {
    Random random = new Random();
    int since = random.nextInt(GitHubServiceConstant.MAX_USER_ID);
    return gitHubOutboundService.getRandomUsers(since);
  }
}
