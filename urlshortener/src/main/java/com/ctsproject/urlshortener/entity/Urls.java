package com.ctsproject.urlshortener.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Urls {

	
	public Urls() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long urlId;
	
	@Column
	private Long userId; 
	
	private String shortUrl;
	private String longUrl;

	private LocalDate creationDate;

	private LocalDate lastAccessDate;
	 
	private int accessCount;

	public Long getUrlId() {
		return urlId;
	}

	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(LocalDate lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public int getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}

	@Override
	public String toString() {
		return "Urls [urlId=" + urlId + ", userId=" + userId + ", shortUrl=" + shortUrl + ", longUrl=" + longUrl
				+ ", creationDate=" + creationDate + ", lastAccessDate=" + lastAccessDate + ", accessCount="
				+ accessCount + "]";
	}

	public Urls(Long urlId, Long userId, String shortUrl, String longUrl, LocalDate creationDate, LocalDate lastAccessDate,
			int accessCount) {
		super();
		this.urlId = urlId;
		this.userId = userId;
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
		this.creationDate = creationDate;
		this.lastAccessDate = lastAccessDate;
		this.accessCount = accessCount;
	}

	

	
	
}
