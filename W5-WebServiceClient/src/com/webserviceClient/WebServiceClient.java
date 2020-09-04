package com.webserviceClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WebServiceClient {
	
	private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://0.0.0.0:9080/W5-WebServiceResource/webresources";
    
	public WebServiceClient() {
		client = javax.ws.rs.client.ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("generic");
	}
	
	public double calculate(double principle, double interest, int noofyears) {
		 WebTarget resource = webTarget;
	        resource = resource.queryParam("principle", principle).queryParam("interest", interest).queryParam("noofyear", noofyears);
	        
	        String response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
	        
	        JSONParser parser = new JSONParser();
	        JSONObject jsonresp = new JSONObject();
	        try {
				jsonresp = (JSONObject) parser.parse(response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        Double amnt = (Double) jsonresp.get("amount");
	        return amnt;
	}

}
