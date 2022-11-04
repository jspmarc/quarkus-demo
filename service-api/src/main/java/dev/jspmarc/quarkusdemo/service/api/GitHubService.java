package dev.jspmarc.quarkusdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface GitHubService {

  Uni<List<GitHubUserResponse>> getRandomUsers();
}
