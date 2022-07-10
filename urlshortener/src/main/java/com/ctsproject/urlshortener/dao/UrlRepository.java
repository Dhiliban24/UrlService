package com.ctsproject.urlshortener.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctsproject.urlshortener.entity.Urls;



@Repository
public interface UrlRepository extends JpaRepository<Urls,Long> {

	public Urls findUrlsByShortUrl(String shortUrl);
	public Urls findUrlsByUrlId(Long urlId);

	@Query("select t from Urls t")
	public List<Urls> findTop2ByAccessCount();

	@Query("select r from Urls r")
	public List<Urls> findRecentlyAdded2ByCreationDate();
	
}
