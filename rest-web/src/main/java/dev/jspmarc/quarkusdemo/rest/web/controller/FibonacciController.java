package dev.jspmarc.quarkusdemo.rest.web.controller;

import dev.jspmarc.quarkusdemo.libraries.DemoExecutorFactory;
import dev.jspmarc.quarkusdemo.service.api.FibonacciService;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/fibonacci")
@Produces(MediaType.TEXT_PLAIN)
public class FibonacciController {

  static DemoExecutorFactory demoExecutorFactory = new DemoExecutorFactory(
      FibonacciController.class.getSimpleName());

  @Inject
  FibonacciService fibonacciService;

  @GET
  public Uni<Long> fibonacci(@RestQuery int n, @RestQuery boolean memoization) {
    Log.info("Got req - n : " + n + " - memoization : " + memoization);
    Uni<Long> uni = null;
    if (memoization) {
      uni = fibonacciService.computeSequenceUsingMemoization(n);
    } else {
      uni = fibonacciService.computeSequence(n);
    }

    return uni.runSubscriptionOn(Executors.newSingleThreadExecutor(demoExecutorFactory));
  }
}
