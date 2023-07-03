package com.sabin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DesignController {
	
@RequestMapping("/design")
	public String design()
	{
		return "design";
	}

}
