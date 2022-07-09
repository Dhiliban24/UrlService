package com.ctsproject.urlshortener.service;

import com.ctsproject.urlshortener.entity.Urls;

public interface UrlShorteningService {
		
	public Urls saveUrl(Urls urls);
	public String fetchUrl(String shortUrl);
	public void deleteUrl(int days);
	public Urls findUrlsByShortUrl(String shortUrl);
	public Urls findUrlsByUrlId(Long urlId);
	
}
