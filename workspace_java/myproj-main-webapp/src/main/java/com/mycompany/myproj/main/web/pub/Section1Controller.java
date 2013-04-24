package com.mycompany.myproj.main.web.pub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/section1")
public class Section1Controller {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayDefault() {

		return new ModelAndView("section1/default-section1.ftl");
	}
	
}
