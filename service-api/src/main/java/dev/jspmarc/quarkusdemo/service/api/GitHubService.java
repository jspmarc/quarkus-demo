package dev.jspmarc.quarkusdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import java.util.List;

public interface GitHubService {

  List<GitHubUserResponse> getRandomUsers();
}
