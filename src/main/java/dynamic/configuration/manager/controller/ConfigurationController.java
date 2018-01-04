package dynamic.configuration.manager.controller;

import javax.validation.Valid;
import javax.ws.rs.DELETE;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.service.ConfigurationService;

@RestController
@CrossOrigin("*")
public class ConfigurationController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

	@Autowired
	ConfigurationService service;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("config", new ConfigurationEntity());
		model.addAttribute("configEntities", service.getConfigurations());
		return "index";
	}

	@PostMapping(value = "/add")
	public String processAdd(@Valid @ModelAttribute("config") ConfigurationEntity entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "index";
		}
		try {
			service.add(entity);
		} catch (Exception e) {
			return "error";
		}
		return "redirect:index";
	}

	@PostMapping(value = "/add")
	public String addConfiguration(ConfigurationEntity entity) {
		try {
			service.add(entity);
		} catch (Exception e) {
			return "error";
		}
		return "redirect:index";
	}

	@PostMapping(value = "/update")
	public String updateConfiguration(ConfigurationEntity entity) {
		try {
			service.update(entity);
		} catch (Exception e) {
			return "redirect:error.html";
		}
		return "redirect:index";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteConfiguration(@RequestParam("id") Long id) {
		try {
			service.deleteById(id);
		} catch (Exception e) {
			return new Long(-1L).toString();
		}
		return id.toString();
	}

}
