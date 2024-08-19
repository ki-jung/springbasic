package com.kj.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicApplication.class, args);
	}

}
// GET - 데이터를 얻을 때 (RequestBody X)
// POST - 데이터를 작성할때 (RequestBody O)
// PUT - 데이터를 전체 수정할 때 (RequestBody O)
// Patch - 데이터를 일부 수정할 때 (RequestBody O)
// DELETE - 데이터를 삭제할 때 (RequestBody X)