package com.rxf113;

import java.util.List;

import io.quarkus.logging.Log;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/fruit")
public class FruitResource {

    FruitRepository fruitRepository;

    public FruitResource(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> fruits(@QueryParam("season") String season) {
        if (season != null) {
            Log.infof("Searching for %s fruits", season);
            return fruitRepository.findBySeason(season);
        }
        return Fruit.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Status.CREATED).entity(fruit).build();
    }

}