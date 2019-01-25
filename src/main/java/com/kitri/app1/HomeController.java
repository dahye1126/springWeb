package com.kitri.app1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value="/test/test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@RequestMapping(value="/test/test1", method=RequestMethod.POST)
	public String test1_post(Test t) { //커맨드 객체, view페이지로 자동 전달
	//public String test1_post(@ModelAttribute("qqq"Test t)) {  => 뷰페이지 name : ${qqq.name }	
		System.out.println(t);
		return "result"; //뷰 페이지 경로
	}

}
