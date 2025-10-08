package com.camelion.testing.resource;

import com.camelion.testing.service.CalculationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/calculate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationResource {

  @Inject
  CalculationService calculationService;

  @GET
  @Path("/addTwoTo/{value}")
  public Response addTwoTo(@PathParam("value") int value) {
    try {
      int result = calculationService.addTwoTo(value);

      if (result < 0) {
        return Response.status(Response.Status.UNAUTHORIZED)
            .entity("CalculationService is down, try again later.")
            .build();
      }

      return Response.ok(result).build();

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity("CalculationService failed, please let support know.")
          .build();
    }
  }
}

