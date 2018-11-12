package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	@Autowired
	private SampleFileMapper sampleFileMapper;
	// 1 샘플리스트
	public List<Sample> getSampleAll(int startRow, int lastRow){
		System.out.println("getSampleAll method......SampleService.java");
		return sampleMapper.selectSampleAll(startRow, lastRow);
	}
	
	// 2. 삭제
	public int removeSample(int sampleNo) {
		System.out.println("removeSample method......SampleService.java");
		SampleFile sampleFile = sampleFileMapper.selectSampleFileName(sampleNo);
		if(sampleFile!=null) { // 기존 file업로드가 없는 샘플들 삭제를 위한 null처리
			sampleFileMapper.deleteSampleFile(sampleNo);
	
	        File file = new File(sampleFile.getSampleFilePath()+"/"+sampleFile.getSampleFileName()+"."+sampleFile.getSampleFileExt());
	        if(file.exists()){
	            if(file.delete()){
	                System.out.println("DELETE FILE SUCCESS......SampleService.java");
	            }else{
	                System.out.println("DELETE FILE FAIL......SampleService.java");
	            }
	        }else{
	            System.out.println("DELETE DOESNT EXIST......SampleService.java");
	        }
		}

		return sampleMapper.deleteSample(sampleNo);
	}

	// 3. 전체글수
	public int totalRow() {
		System.out.println("removeSample method......SampleService.java");
		return sampleMapper.totalRow();
	}
	
	// 4. 추가
	public int addSample(SampleRequest sampleRequest) {
		System.out.println("addSample method......SampleService.java");

		//SampleRequest-->sample
		//1. multipartFile 파일데이터-> 저장
		//2. multipartFile 정보 -> 새로운정보 추가 ->SampleFile
		//-------------------------------------------------------------------
		//1.
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.insertSample(sample);	// auto increasment -> sampleNo
		//2.
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
		// 1. SampleFileNo : AI	
		// 2. SampleNo
		System.out.println(sample.getsampleNo()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		sampleFile.setSampleNo(sample.getsampleNo());
		// 3. SampleFileExt
		System.out.println(multipartFile.getOriginalFilename()+"......SampleService.java");
		String originalFileName = multipartFile.getOriginalFilename();
		String ext = originalFileName.substring(0); // subString 채우기
		sampleFile.setSampleFileExt(ext);
		// 4. SampleFileName
		String fileName = UUID.randomUUID().toString();
		sampleFile.setSampleFileName(fileName);
		// 5. SampleFilePath
		String path = "c:\\uploads";
		sampleFile.setSampleFilePath(path);
		// 6. SampleFileType
		sampleFile.setSampleFileType(multipartFile.getContentType());
		// 7. sampleFileSize
		sampleFile.setSampleFileSize(multipartFile.getSize());
		// 원하는 이름의 빈파일 하나 생성
		try {
			multipartFile.transferTo(new File(path+"\\"+fileName+"."+ext));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sampleFileMapper.insertSampleFile(sampleFile);
	}
	
	// 5-1. 수정을위한 조회
	public Sample getSample(int sampleNo) {
		System.out.println("getSample method......SampleService.java");
		return sampleMapper.selectOne(sampleNo);
	}
	
	// 5-2. 수정
	public int modifySample(Sample sample) {
		System.out.println("modifySample method......SampleService.java");
		return sampleMapper.updateSample(sample);
	}
	
	public int loginSample(Sample sample) {
		System.out.println("loginSample method......SampleService.java");
		return sampleMapper.loginSample(sample);
	}
	
}