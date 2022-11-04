package dev.jspmarc.quarkusdemo.rest.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/test")
public class TestController {

  @GET
  @ResponseStatus(418)
  @Produces(MediaType.TEXT_PLAIN)
  public String test() {
    return "私はティーポットです";
  }
}
