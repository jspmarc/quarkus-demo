package dev.jspmarc.quarkusdemo.outbound.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import java.util.List;

public interface GitHubOutboundService {

  List<GitHubUserResponse> getRandomUsers(int since);
}
