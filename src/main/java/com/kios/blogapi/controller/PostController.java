package com.kios.blogapi.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kios.blogapi.entity.Post;
import com.kios.blogapi.repository.PostRepository;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody Post post){
		Post p = postRepository.save(post);
		if(p!=null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Post>> getPage(Pageable pageable, Sort sort){
		Page<Post> posts = postRepository.findAll(pageable);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/dev")
	public void test() {
		
	}
	
//	@Async("threadPoolTaskExecutor")
//	public CompletableFuture<String> testtest() throws InterruptedException {
//		String url = String.format("https://api.github.com/users/%s", "johnnyedgett");	
//	}
}
