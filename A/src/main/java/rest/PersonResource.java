package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mappers.PersonMapper;
import mappers.PersonsMapper;

@Path("person")
public class PersonResource {
    
    private static Facade fc = new Facade();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;
    
    public PersonResource() {
    }
    
    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = fc.getPersons();
        return gson.toJson(new PersonsMapper(persons));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete/{id}")
    public Response getPerson(@PathParam("id") int id) {
        
        Person p = fc.getPerson(id);
        if (p == null) {
            JsonObject error = new JsonObject();
            error.addProperty("code", "404");
            error.addProperty("message", "No person with provided id found");
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(error)).build();
        }
        PersonMapper pm = new PersonMapper(p);
        return Response.status(Response.Status.OK).entity(gson.toJson(pm)).build();
    }
    
    @GET
    @Path("complete2")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons2() {
        List<Person> persons = fc.getPersons();
        
        JsonObject allPersons = new JsonObject();
        JsonArray allPersonsArray = new JsonArray();
        
        for (Person p : persons) {
            JsonObject thePerson = new JsonObject();
            
            thePerson.addProperty("FirstName", p.getFirstName());
            thePerson.addProperty("LastName", p.getLastName());
            thePerson.addProperty("Street", p.getAddress().getStreet());
            thePerson.addProperty("Test", "Patrick");
            allPersonsArray.add(thePerson);
        }
        allPersons.add("persons", allPersonsArray);
        return allPersons.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("phone/{phone}")
    public String getPersonInfo(@PathParam("phone") int phone) {
        
        
        return new Gson().toJson(fc.getPersonByPhone(phone));
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
