package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	// 1. 샘플목록
	@RequestMapping(value = "/sample/sampleList", method = RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="currentPage", required=false,defaultValue="0") int currentPage) {
		System.out.println("sampleList method......SampleController.java");
		int totalRow = sampleService.totalRow();
		int startRow = currentPage*10;
		int lastRow = 10; //표시할 글 개수
		int lastPage = totalRow/lastRow-1;
		if(totalRow%lastRow!=0) {
			lastPage+=1;
		}
		System.out.println(totalRow+"<<<<<<totalRow");
		System.out.println(currentPage+"<<<<<current");
		System.out.println(startRow+"<<<<<startRow");
		System.out.println(lastPage+"<<<<<lastPage");
		
		List<Sample> sampleList = sampleService.getSampleAll(startRow, lastRow);
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		//model.addAttribute();
		return "/sample/sampleList";
	}
	
	// 2. 삭제
	@RequestMapping(value = "/sample/removeSample", method = RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("removeSample method......SampleController.java");
		if(sampleService.removeSample(sampleNo)==1) {
			System.out.println(sampleNo+"번 데이터 삭제 성공");
		};
		return "redirect:/sample/sampleList";
	}	
	
}
