package dynamic.configuration.manager.controller;

import dynamic.configuration.manager.app.ConfigurationReader;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import dynamic.configuration.manager.service.ConfigurationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Path("/config")
@CrossOrigin("*")
public class ConfigurationController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    ConfigurationService service;


    @PUT
    @Path("/add")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response addConfiguration(@RequestBody ConfigurationEntity entity) {
        try {
            service.add(entity);
        } catch (Exception e) {
            return Response.serverError().entity(entity).build();
        }
        return Response.ok().entity("Operation Done").build();
    }

    @POST
    @Path("/update")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response updateConfiguration(@RequestBody ConfigurationEntity entity) {
        try {
            service.update(entity);
        } catch (Exception e) {
            return Response.serverError().entity(entity).build();
        }
        return Response.ok().entity("Operation Done").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteConfiguration(@PathParam("id") long id) {
        try {
            service.deleteById(id);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok().entity("Operation Done").build();
    }

    @GET
    @Path("/getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List getAllConfigurations() {
        return service.getConfigurations();
    }

    @GET
    @Path("/getByName/{name}")
    public ConfigurationEntity getByName(@PathParam("name") String name) {
        return service.getByName(name);
    }
}
