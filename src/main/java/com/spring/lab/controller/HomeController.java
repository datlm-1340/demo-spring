package com.spring.lab.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.lab.model.User;
import com.spring.lab.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		List<User> users = userService.findAll();
		request.setAttribute("users", users);
		
		return("index");
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String update(HttpServletRequest request, @RequestParam long id) {
		User user = userService.findById(id);
		request.setAttribute("user", user);
		
		return("edit");
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String create(Model model, @RequestParam String email, @RequestParam String fullName ) {
		userService.createUser(email, fullName);
		model.addAttribute("message", "Success!");
		return("redirect:/");
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String update(Model model, @RequestParam long id, @RequestParam String email, @RequestParam String fullName ) {
		userService.updateUser(id, email, fullName);
		model.addAttribute("message", "Success!");
		return("redirect:/user?id=" + id);
	}
	
	@RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(HttpServletRequest request, @RequestParam long id ) {
		userService.delete(id);
		
		return("redirect:/");
	}
}
