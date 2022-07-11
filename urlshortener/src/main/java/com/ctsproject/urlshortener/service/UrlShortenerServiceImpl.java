package com.ctsproject.urlshortener.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ctsproject.urlshortener.dao.UrlRepository;
import com.ctsproject.urlshortener.entity.Urls;
import com.ctsproject.urlshortener.entity.User;
import com.ctsproject.urlshortener.mapper.UserUrlMapper;



@Service
public class UrlShortenerServiceImpl implements UrlShorteningService {

	@Autowired
	UrlRepository urlRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	RestTemplate restTemplate;
	
	private  String answer="";
	public String shortUrl(String URL) {
		
		try {	
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	        byte[] input = URL.getBytes("UTF-8");
	        byte[] md5hash = messageDigest.digest(input);
	        Base64.Encoder encoder = Base64.getEncoder();
	        String encodeToString = encoder.encodeToString(md5hash);
	        int shortKeyType =  3;
	        String tinyUrlKey = shortKeyType ==1 ? encodeToString.substring(0,6) : shortKeyType == 2 ? encodeToString.substring(0,8) : randomlySelect8Chars(encodeToString);
	        answer=tinyUrlKey;
	        System.out.println("ShortKey --> " + answer);
			}
			catch(NoSuchAlgorithmException e) {
				System.out.println("algo");
			}
			catch(UnsupportedEncodingException e) {
				System.out.println("encoding");
			}
		
		return answer;
	}
	private static String randomlySelect8Chars(String encodeToString) {
        Random random = ThreadLocalRandom.current();
        char[] encodedChars =  encodeToString.toCharArray();
        assert encodedChars.length == 21;
        for(int i=20; i >=0; i--) {
            int randomIndex =  random.nextInt(i+1);
            swap(encodedChars,randomIndex,i);
        }
        return new String(encodedChars,0,8);
}

	private static void swap(char[] chars, int i, int j) {
	        char temp = chars[i];
	        chars[i] = chars[j];
	        chars[j] = temp;
	    }
	

	@Override
	public Urls saveUrl(Urls urls) {
		System.out.println("urls shortening occurs..");
		String shortUrl= shortUrl(urls.getLongUrl());
		urls.setShortUrl(shortUrl);
		return urlRepository.save(urls);
	}
	@Override
	public String fetchUrl(String shortUrl) {
		
		return null;
	}
	@Override
	public void deleteUrl(int days) {
		
		
	}
	@Override
	public Urls findUrlsByShortUrl(String shortUrl) {
		// TODO Auto-generated method stub
		return urlRepository.findUrlsByShortUrl(shortUrl);
	}
	@Override
	public Urls findUrlsByUrlId(Long urlId) {
		// TODO Auto-generated method stub
		return  urlRepository.findUrlsByUrlId(urlId);
	}
	
	@Override
	public UserUrlMapper fetchUserAndUrlById(Long id) {
		UserUrlMapper mapped = new UserUrlMapper();
		Urls url = urlRepository.findById(id).get();
		System.out.println(url);
		User usr = restTemplate.getForObject("http://localhost:8081/url/userById/"+url.getId(), User.class);

		mapped.setUser(usr);
		mapped.setUrls(url);
		return mapped;
	}
	
	@Override
	public Urls updateUserId(Urls url,Long id) {
		Urls u= urlRepository.findUrlsByUrlId(url.getUrlId());
		u.setid(id);
		return urlRepository.save(u);
	}
	@Override
	public Urls updateUrlCount(Urls url) {
		
		Urls u = urlRepository.findUrlsByUrlId(url.getUrlId());		
		u.setAccessCount(u.getAccessCount()+1);
		return urlRepository.save(u);
	}
	
	@Override
	public List<Urls> findTopUrlsByCount() {
		
		return entityManager.createQuery("select t from Urls t ORDER BY t.accessCount DESC",Urls.class)
		.setMaxResults(10).getResultList();
	}

}
