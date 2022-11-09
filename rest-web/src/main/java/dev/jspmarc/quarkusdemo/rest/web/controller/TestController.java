package dev.jspmarc.quarkusdemo.rest.web.controller;

import dev.jspmarc.quarkusdemo.libraries.DemoExecutorFactory;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/test")
public class TestController {

  static DemoExecutorFactory fact = new DemoExecutorFactory(TestController.class.getSimpleName());

  @GET
  @ResponseStatus(418)
  @Produces(MediaType.TEXT_PLAIN)
  public String test() {
    return "私はティーポットです";
  }

  @GET
  @Path("/play")
  @Produces
  public Uni<Void> play() {
    var uni = Uni.createFrom().item("halo");
    var t1 = uni.emitOn(Executors.newSingleThreadExecutor(fact)).onItem().invoke(i -> {
          try {
            Thread.sleep(2000);
          } catch (InterruptedException ignored) {
          }
          Log.info("Got invoke " + i);
        })
        .map(i -> {
          try {
            Thread.sleep(100);
          } catch (InterruptedException ignored) {
          }
          Log.info(i);
          return i;
        });
    var t2 = uni.emitOn(Executors.newSingleThreadScheduledExecutor(fact)).onItem().call(i -> {
      try {
        Thread.sleep(500);
      } catch (InterruptedException ignored) {
      }
      Log.info("Got call " + i);
      return Uni.createFrom().item(i + " modified");
    }).map(i -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ignored) {
      }
      Log.info(i);
      return i;
    });

    Log.info("returning...");

    return Uni.combine().all().unis(t1, t2).combinedWith(t -> {
      Log.info("Objects: " + t);
      return null;
    });
  }
}
