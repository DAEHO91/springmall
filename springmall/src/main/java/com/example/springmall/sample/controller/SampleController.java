package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		int totalRow = sampleService.totalRow(); // 전체 데이터의 개수를 리턴받는다
		int startRow = currentPage*10; 	// 시작되는 Row를 지정.. 입력받은 커런트페이지가 없을시 초기갑 0으로 시작 -> 0번째에서 10개의 데이터를 가져옴
										// 페이지 이동으로 currentPage = 2 할당시 2*10=20 ,  20번째에서 10개의 데이터를 가져오기 위한 세팅
		int lastRow = 10; //표시할 글 개수
		int lastPage = totalRow/lastRow-1;	// 페이지 수 표시를 위한 세팅...
		if(totalRow%lastRow!=0) {
			lastPage+=1;	// 나머지가 있을 경우 짤리지않게 +1로 나머지도 출력
		}
		
		List<Sample> sampleList = sampleService.getSampleAll(startRow, lastRow);
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
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
	
	// 3-1. 입력폼
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.GET)
	public String addSample() {
		System.out.println("forward insert form addSampleGET......SampleController.java");
		return "/sample/addSample";
	}	
	
	// 3-2. 입력 액션
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.POST)
	public String addSample(@ModelAttribute("sample") Sample sample) { // command 객체... command 객체의 멤버변수 == input 태그 name 속성이 같아야함
		System.out.println("forward insert action addSamplePOST......SampleController.java");
		int row = sampleService.addSample(sample);
		if(row==1) { // 리턴값 1일 시 성공적으로 입력
			System.out.println("INSERT SUCCESS!......SampleController.java");
			return "redirect:/sample/sampleList";
		}else { // 예외 발생시 1이 아닌값이 리턴
			System.out.println("INSERT FAIL!......SampleController.java");
			return "/sample/addSample";
		}
	}
	
	// 4-1 수정폼
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("modifySampleGET......SampleController.java");
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		return "/sample/modifySample";
	}
	
	
	// 4-2 수정액션
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.POST)
	public String modifySample(@ModelAttribute("sample") Sample sample) {
		System.out.println("modifySamplePOST......SampleController.java");
		int result = sampleService.modifySample(sample);
		if(result==1) { // 리턴값 1일시 성공적으로 수정
			System.out.println("MODIFY SUCCESS!......SampleController.java");
			return "redirect:/sample/sampleList";
		} else { // 예외 발생시 1이 아닌값이 리턴
			System.out.println("MODIFY FAIL!......SampleController.java");
			return "/sample/modifySample";
		}
	}
}





