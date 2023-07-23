package com.rxf113.resource;

import com.rxf113.model.Cat;
import com.rxf113.repository.PersonRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/person")
public class PersonResource {

    private final PersonRepository cusRepository;

    public PersonResource(PersonRepository cusRepository) {
        this.cusRepository = cusRepository;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@PathParam("id") String id) {
        return Response.status(Status.OK).entity(cusRepository.getPersonFullInfoById(id)).build();
    }

    @PUT
    @Path("/cat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(rollbackOn = Exception.class)
    public Response addCat(Cat cat) {
        PanacheEntityBase.persist(cat);
        return Response.status(Status.OK).entity(true).build();

    }
}