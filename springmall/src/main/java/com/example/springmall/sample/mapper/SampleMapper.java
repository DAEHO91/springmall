package com.example.springmall.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper {
	// 1. insert
	int insertSample(Sample sample);
	// 2. select all
	List<Sample> selectSampleAll(int startRow, int lastRow);
	// 3. delete
	int deleteSample(int sampleNo);
	// 4. update
	int updateSample(Sample sample);
	// 5. total count
	int totalRow();
	// 6. select one
	Sample selectOne(int sampleNo);
	// 7. login
	int loginSample(Sample sample);
	
}


// 인터페이스와 추상클래스에 대해 알아보기
// 인터페이스는 다중 구현 가능
// 추상클래스는 다중상속이 불가능하기때문에 인터페이스로 구분하여 사용



// 추상화 상속 다양성 캡슐화
