package com.abdul.springprojects.boot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abdul.springprojects.boot.feign.FeignServiceTemplate;
 

@RestController
@RequestMapping(value="/router")
public class EndPointController {
	
	
private static Logger logger = LoggerFactory.getLogger(EndPointController.class);


@Autowired
private FeignServiceTemplate restTemplate;
	
	@RequestMapping(value="/service", method=RequestMethod.PUT)
	public ResponseEntity<Void> addRoute(@RequestBody EndPointConfig endPointConfig){
		logger.info(endPointConfig.getFrom().toString());
		EndPointBuilder  endPointBuilder = new EndPointBuilder(endPointConfig);
		logger.info(endPointBuilder.getEndPointObject().getFromEndPoint());
		String response = restTemplate.createRoute(endPointBuilder.getEndPointObject());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}
	
	
	

}
