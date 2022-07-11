package com.ctsproject.urlshortener.service;

import java.util.List;

import com.ctsproject.urlshortener.entity.Urls;
import com.ctsproject.urlshortener.mapper.UserUrlMapper;

public interface UrlShorteningService {
		
	public Urls saveUrl(Urls urls);
	public String fetchUrl(String shortUrl);
	public void deleteUrl(int days);
	public Urls findUrlsByShortUrl(String shortUrl);
	public Urls findUrlsByUrlId(Long urlId);
	public UserUrlMapper fetchUserAndUrlById(Long id);
	public Urls updateUserId(Urls url,Long id); 
	public Urls updateUrlCount(Urls url);
	public List<Urls> findTopUrlsByCount();
	
}
