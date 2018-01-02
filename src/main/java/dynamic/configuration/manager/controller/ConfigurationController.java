package dynamic.configuration.manager.controller;

import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@RestController
@Path("/config")
public class ConfigurationController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    ConfigurationRepository repository;

    @PUT
    @Path("/add")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addConfiguration(@RequestBody ConfigurationEntity entity) {
        try {
            repository.save(entity);
        } catch (Exception e) {
            logger.error("Couldn't save ", e.getCause());
            return Response.serverError().entity(entity).build();
        }
        return Response.ok().build();
    }
}
