package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class LoginController {
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value = "/sample/login", method = RequestMethod.POST)
	public String login(Sample sample, HttpSession session) {
		System.out.println("login method......LoginController.java");

		if(sampleService.loginSample(sample)==1) {
			System.out.println("Login Success!.......LoginController.java");
			session.setAttribute("LOGINID", sample.getSampleId());
			return "redirect:/sample/sampleList";
		} else {
			System.out.println("Login Fail!.......LoginController.java");
			return "redirect:/sample/sampleList";
		}
	}

	@RequestMapping(value = "/sample/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sample/sampleList";
	}
}
