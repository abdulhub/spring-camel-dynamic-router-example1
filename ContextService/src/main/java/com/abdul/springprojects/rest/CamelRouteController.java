package com.abdul.springprojects.rest;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camel")
public class CamelRouteController {

	public static Logger logger = LoggerFactory.getLogger(CamelRouteController.class);

	@Autowired
	private CamelContext camelContext;

	@RequestMapping(value = "/addRoute", method = RequestMethod.PUT)
	public String createRoute(@RequestBody EndPointObject endPointObject) {

		try {
			camelContext.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					// TODO Auto-generated method stub

					from(endPointObject.getFromEndPoint())
					         .to(endPointObject.getToEndPoints().get(0))
							 .to(endPointObject.getToEndPoints().get(1))
					     .routeId(endPointObject.getServiceId());

				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/deleteRoute", method = RequestMethod.DELETE)
	public String deleteRoute(@RequestBody EndPointObject endPointObject) {

		return null;

	}

}
