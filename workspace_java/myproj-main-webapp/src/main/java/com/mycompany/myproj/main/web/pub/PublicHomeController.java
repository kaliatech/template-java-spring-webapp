package com.mycompany.myproj.main.web.pub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PublicHomeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayDefault() {

		return new ModelAndView("home.ftl");
	}
	
}
