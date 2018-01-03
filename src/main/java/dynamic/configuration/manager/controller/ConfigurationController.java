package dynamic.configuration.manager.controller;

import dynamic.configuration.manager.app.ConfigurationReader;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import dynamic.configuration.manager.service.ConfigurationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/config")
@CrossOrigin("*")
public class ConfigurationController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    ConfigurationService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addConfiguration(@RequestBody ConfigurationEntity entity) {
        try {
            service.add(entity);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateConfiguration(@RequestBody ConfigurationEntity entity) {
        try {
            service.update(entity);
        } catch (Exception e) {
            return "redirect:error.html";
        }
        return "redirect:index";
    }

    @DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteConfiguration(@RequestParam("id") Long id) {
        try {
            service.deleteById(id);
        } catch (Exception e) {
            return new Long(-1L).toString();
        }
        return id.toString();
    }

    @GET
    @Path("/getAll")
    @ResponseBody
    public String getAllConfigurations(Model model) {
        model.addAttribute("configEntities", service.getConfigurations());
        return "index";
    }

    @GET
    @Path("/getByName/{name}")
    @ResponseBody
    public String getByName(@PathParam("name") String name, Model model) {
        model.addAttribute("configEntity", service.getByName(name));
        return "/configEntity";
    }
}
