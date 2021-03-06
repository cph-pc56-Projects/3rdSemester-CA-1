package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Person> data = fc.getPersons();
        return gson.toJson(new PersonsMapper(data, true));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPerson(@PathParam("id") int id) {

        Person p = fc.getPerson(id);
        if (p == null) {
            JsonObject error = new JsonObject();
            error.addProperty("code", "404");
            error.addProperty("message", "No person with provided id found");
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(error)).build();
        }
        PersonMapper pm = new PersonMapper(p, true);
        return Response.status(Response.Status.OK).entity(gson.toJson(pm)).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String PersonFirstName = "";
        String PersonLastName = "";
        String PersonEmail = "";
        
        if(body.has("fName")) {
            PersonFirstName = body.get("fName").getAsString();
        }
        if(body.has("lName")) {
            PersonLastName = body.get("lName").getAsString();
        }
        if (body.has("email")){
            PersonEmail = body.get("email").getAsString();
        }
        Person p = new Person();
        p.setFirstName(PersonFirstName);
        p.setLastName(PersonLastName);
        fc.addPerson(p);
        p.setEmail(PersonEmail);
        fc.editPerson(p);
        return gson.toJson(p);
    }
    

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @DELETE
    @Path("{id}")
    public String deletePerson(@PathParam("id") int id) {

        if (fc.deletePerson(id) == null) {
            return "No such person found";
        }
        return gson.toJson(fc.deletePerson(id));

    }
}
