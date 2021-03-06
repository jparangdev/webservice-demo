package kr.co.jparangdev.webservicedemo.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jparangdev.webservicedemo.service.PostsService;
import kr.co.jparangdev.webservicedemo.web.dto.PostsRequestSaveDto;
import kr.co.jparangdev.webservicedemo.web.dto.PostsRequestUpdateDto;
import kr.co.jparangdev.webservicedemo.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsController {

	private final PostsService service;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsRequestSaveDto postsRequestSaveDto) {
		return service.save(postsRequestSaveDto);
	}

	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long udpate(@PathVariable("id") Long id, @RequestBody
		PostsRequestUpdateDto request) {
		return service.update(id, request);
	}

	@DeleteMapping("/api/v1/posts/{id}")
	public Long delete(@PathVariable("id") Long id){
		service.delete(id);
		return id;
	}
}
