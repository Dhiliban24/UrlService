package com.ctsproject.urlshortener.mapper;

import com.ctsproject.urlshortener.entity.Urls;
import com.ctsproject.urlshortener.entity.User;

public class UserUrlMapper {

	private Urls urls;
	private User user;
	
	
	public UserUrlMapper() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserUrlMapper(Urls urls, User user) {
		super();
		this.urls = urls;
		this.user = user;
	}


	public Urls getUrls() {
		return urls;
	}


	public void setUrls(Urls urls) {
		this.urls = urls;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserUrlMapper [urls=" + urls + ", user=" + user + "]";
	}
	
	

}



