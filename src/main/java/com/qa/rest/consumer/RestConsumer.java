package com.qa.rest.consumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.Constants;
import com.qa.model.Quote;

@Service
public class RestConsumer {
	
	public Quote invokeApi() 
	{
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(Constants.API_URL, Quote.class);
	}
}
