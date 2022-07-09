package com.ctsproject.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctsproject.urlshortener.entity.Urls;
import com.ctsproject.urlshortener.service.UrlShorteningService;

@RestController
@RequestMapping("urls")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class UrlController {
	
	@Autowired
	UrlShorteningService urlShorteningService;
	
	@GetMapping("/")
	public String sayHi() {
		return "Url Shortening Service";
	}
	
	@PostMapping("/short")
	public Urls saveShortUrl(@RequestBody Urls urls) {
		System.out.println(urls);
		return urlShorteningService.saveUrl(urls);
	}
	
	@GetMapping("/urlByShort/{url}")
	public ResponseEntity<Urls> findUrlByShort(@PathVariable("url") String shortUrl) {
		Urls answer= urlShorteningService.findUrlsByShortUrl(shortUrl);
		System.out.println("Url");
		System.out.println(answer.getLongUrl());
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Urls> entity =new ResponseEntity<>(answer,headers,HttpStatus.ACCEPTED);
		return entity;  
	} 
	@GetMapping("/urlById/{userId}")
	public Urls findUrlByUrlId(@PathVariable("userId") Long urlId) {
		Urls answer= urlShorteningService.findUrlsByUrlId(urlId);
		return answer;
	}	

}
