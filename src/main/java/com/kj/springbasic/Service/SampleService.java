package com.kj.springbasic.Service;

import org.springframework.http.ResponseEntity;

import com.kj.springbasic.dto.PostSample1RequestDto;

public interface SampleService {

    ResponseEntity<String> postSample1(PostSample1RequestDto dto);

    ResponseEntity<String> deleteSample1(String sampleId);

    ResponseEntity<String> queryString();
}
