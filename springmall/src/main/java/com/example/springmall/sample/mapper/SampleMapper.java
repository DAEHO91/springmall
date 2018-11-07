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
}
