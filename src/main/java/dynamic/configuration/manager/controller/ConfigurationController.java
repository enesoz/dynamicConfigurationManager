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
import java.util.Date;
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


    @PostMapping("addConfiguration")
    public String addConfiguration(@Valid @ModelAttribute("config") ConfigurationEntity entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        entity.setCreatedTime(new Date());
        entity.setActive(true);
        service.add(entity);
        return "redirect:/";
    }

    @PostMapping("edit")
    public String edit(Model model, @RequestParam("id") String id) {
        ConfigurationEntity entity = service.getRepository().findById(id).get();
        model.addAttribute("config", entity);
        return "/edit";
    }

    @PostMapping(value = "/update")
    public String updateConfiguration(ConfigurationEntity entity) {
        try {
            entity.setUpdatedTime(new Date());
            service.update(entity);
        } catch (Exception e) {
            return "/";
        }
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete")
    public String deleteConfiguration(@RequestParam("id") String id) {
        service.deleteById(id);
        return "redirect:/";
    }

}
