package com.hyuni.miniblogapi;

import com.hyuni.miniblogapi.domain.Post;
import com.hyuni.miniblogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniBlogApiApplication {

	@Autowired private PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(MiniBlogApiApplication.class, args);
	}

}
