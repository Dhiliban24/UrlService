package com.ctsproject.urlshortener.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctsproject.urlshortener.entity.Urls;

@Repository
public interface UrlRepository extends JpaRepository<Urls,Long> {

	public Urls findUrlsByShortUrl(String shortUrl);
	public Urls findUrlsByUrlId(Long urlId);
}
