package com.webservice;

import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.json.simple.JSONObject;

import com.CalculatorInterface;
import com.CalculatorSessionBean;

@Path("generic")
public class CalculatorService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public CalculatorService() {
        // TODO Auto-generated constructor stub
    }
    
    @EJB
    private CalculatorInterface calculatorejb;
    //private CalculatorSessionBean calculatorejb;
   // private CalculatorSessionBean calculateBean;
    /**
     * Retrieves representation of an instance of CalculatorService
     * @return an instance of Json
     */
    @GET
    @Produces("application/json")
    public JSONObject getJson(@DefaultValue("2") @QueryParam("principle") double principle,
    		@DefaultValue("2") @QueryParam("interest") double interest,
    		@DefaultValue("2") @QueryParam("noofyears") int noofyears) {

    	double amount = calculatorejb.calculate(principle, noofyears, interest);
    	
    	
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
    public void putJson(Json content) {
    }

}