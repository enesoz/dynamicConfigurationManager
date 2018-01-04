package dynamic.configuration.manager.controller;

import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.service.ConfigurationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.Map;

@Controller
public class ConfigurationController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    ConfigurationService service;

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {
        model.put("config", new ConfigurationEntity());
        model.put("configEntities", service.getConfigurations());
        return "index";
    }

    @RequestMapping(value = "add")
    public String addStudent(Model model) {
        model.addAttribute("config", new ConfigurationEntity());
        return "addConfiguration";
    }


    @PostMapping("addConfigurationa")
    public String processAdd(@Valid @ModelAttribute("config") ConfigurationEntity entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "redirect:/index";
        }
        try {
            service.add(entity);
        } catch (Exception e) {
            logger.error("Error occured", e.fillInStackTrace());
            return "redirect:/index";
        }
        return "redirect:/index";
    }

    @PostMapping("addConfiguration")
    public String addConfiguration(@Valid @ModelAttribute("config") ConfigurationEntity entity) {
        try {
            service.add(entity);
        } catch (Exception e) {
            System.out.println(e);
            logger.error("Error occured", e.fillInStackTrace());
            return "error";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateConfiguration(ConfigurationEntity entity) {
        try {
            service.update(entity);
        } catch (Exception e) {
            return "/";
        }
        return "redirect:index";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteConfiguration(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
        } catch (Exception e) {
            logger.error("Error occured", e.fillInStackTrace());
            return "error";
        }
        return id.toString();
    }

}
