package com.kj.springbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kj.springbasic.Service.SampleService;
import com.kj.springbasic.dto.PostSample1RequestDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("")
    public ResponseEntity<String> postSample1(
            @RequestBody @Valid PostSample1RequestDto requestBody) {
            ResponseEntity<String> response = sampleService.postSample1(requestBody);
            return response;
    }

}