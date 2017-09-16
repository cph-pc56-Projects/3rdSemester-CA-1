/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Hobby;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mappers.HobbiesMapper;
import mappers.HobbyMapper;
import mappers.PersonsMapper;

/**
 * REST Web Service
 *
 * @author trez__000
 */
@Path("hobby")
public class HobbyResource {

    private static Facade fc = new Facade();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HobbyResource
     */
    public HobbyResource() {
    }

    /**
     * Retrieves representation of an instance of rest.HobbyResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Hobby> hobbies = fc.getHobbies();
        HobbiesMapper hsm = new HobbiesMapper(hobbies);
        List<HobbyMapper> m = hsm.hobbies;
        return gson.toJson(m);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsInHobby(@PathParam("id") int id) {
        try {
            List<Person> ppl = fc.getHobby(id).getPersons();
            return gson.toJson(new PersonsMapper(ppl, true));

        } catch(Exception e)  {
            return "No such hobby ID";
        }
    }

    /**
     * PUT method for updating or creating an instance of HobbyResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
