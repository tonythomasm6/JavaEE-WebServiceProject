package com.webservice;

import javax.ejb.EJB;
import org.json.simple.JSONObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.sessionBean.CalculatorSessionBean;

@Path("calculate")
public class CalculatorService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;
    
    @EJB
    private CalculatorSessionBean calc;
    /**
     * Default constructor. 
     */
    public CalculatorService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of CalculatorService
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public JSONObject getJson(@DefaultValue("2") @QueryParam("principle") double principle,
    		@DefaultValue("2") @QueryParam("interest") double interest,
    		@DefaultValue("2") @QueryParam("noofyears") int noofyears) {
    	
    	double amount = calc.calculate(principle, noofyears, interest);
    	
    	
    	JSONObject obj = new JSONObject();
    	obj.put("amount", amount);

    	return obj;
    }

    /**
     * PUT method for updating or creating an instance of CalculatorService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}