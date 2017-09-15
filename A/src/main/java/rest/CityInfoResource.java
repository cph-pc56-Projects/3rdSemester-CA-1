/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import CustomExceptions.PersonNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.CityInfo;
import facade.Facade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author felesiah
 */
@Path("CityInfo")
public class CityInfoResource {
     List<CityInfo> cityinfo; 
    private static Facade fc = new Facade();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    int nextId = 0;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CityInfoResource
     */
    public CityInfoResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CityInfoResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCity(@PathParam("id") int id) {
        CityInfo cf = fc.getCity(id);
        if (cf == null){
            throw new PersonNotFoundException();
        }
        return gson.toJson(cf);
    }
    
@GET
@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
public String getCities(){
String city = null ;
try 
{
cityinfo = fc.getZipcodes();
System.out.println(gson.toJson(cityinfo));
city = gson.toJson(cityinfo);
}
catch (Exception e)
{
System.out.println("Exception Error"); //Console 
}
return city;
}

    /**
     * PUT method for updating or creating an instance of CityInfoResource
     * @param id
     * @return 
     */
  
  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteJson(@PathParam("id") int id) {
    CityInfo ci = cityinfo.remove(id); 
    return gson.toJson(ci);
  }
     
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String putJson(String cityAsJson) {
    CityInfo ci = gson.fromJson(cityAsJson, CityInfo.class);
    ci.setZipCode(nextId); 
    nextId++;
    return gson.toJson(ci);
  }
    
    
}
