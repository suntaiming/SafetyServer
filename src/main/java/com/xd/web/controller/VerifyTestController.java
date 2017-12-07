package com.xd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VerifyTestController {

	@RequestMapping("/sso/client/loginByST")
	@ResponseBody
	public String teset(){
		
		return "nihao";
	}
}
