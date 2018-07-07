package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.constants.Constants;
import com.qa.model.Quote;
import com.qa.rest.consumer.RestConsumer;
import com.qa.util.FileUtility;

@RestController
public class FileController {

	@Autowired
	private RestConsumer consumer;
	@Autowired
	private FileUtility fileUtility;
	
	@RequestMapping(Constants.INVOKE)
	public Quote index() {
		Quote quote = consumer.invokeApi();
		fileUtility.writeToFile(quote);
		return quote;
	}

}