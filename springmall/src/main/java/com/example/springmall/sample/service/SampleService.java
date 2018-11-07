package com.example.springmall.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	// 1 샘플리스트
	public List<Sample> getSampleAll(int startRow, int lastRow){
		System.out.println("getSampleAll method......SampleService.java");
		return sampleMapper.selectSampleAll(startRow, lastRow);
	}
	
	// 2. 삭제
	public int removeSample(int sampleNo) {
		System.out.println("removeSample method......SampleService.java");
		return sampleMapper.deleteSample(sampleNo);
	}

	// 3. 전체글수
	public int totalRow() {
		System.out.println("removeSample method......SampleService.java");
		return sampleMapper.totalRow();
	}
	
}