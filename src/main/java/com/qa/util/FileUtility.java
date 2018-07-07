package com.qa.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.constants.Constants;
import com.qa.model.Quote;

@Service
public class FileUtility {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);
	
	public void writeToFile(Quote quote) 
	{
		LOGGER.info("Success: FileUtility writeToFile");
		String fileLocation = Constants.FILE_LOCATION;
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileLocation))) {
        	String jsonStr = mapper.writeValueAsString(quote);
        	writer.write(jsonStr);
        } 
        catch (IOException e) {
        	LOGGER.error("An error has been throw " + e.getMessage());
		}
	}
	
}
