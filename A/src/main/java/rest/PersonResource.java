package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Person;
import facade.Facade;
import javax.persistence.Persistence;
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

@Path("person")
public class PersonResource {

    private Facade fc;
    private Gson gson;

    public PersonResource() {
        fc = new Facade();
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String getPersons() {
        return new Gson().toJson(fc.getPersons());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getPerson(@PathParam("id") int id) {
        
            Person p = fc.getPerson(id);
            if (p == null) {
                JsonObject error = new JsonObject();
                error.addProperty("code", "404");
                error.addProperty("message", "No person with provided id found");
                return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(error)).build();
            }
            return Response.status(Response.Status.OK).entity(gson.toJson(p)).build();
            
            
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String PersonFirstName = "";
        String PersonLastName = "";
        

        if (body.has("firstName")) {
            PersonFirstName = body.get("firstName").getAsString();
        }
        if (body.has("lastName")) {
            PersonLastName = body.get("lastName").getAsString();
        }
        

        Person p = new Person(PersonFirstName, PersonLastName);
        fc.addPerson(p);

        return new Gson().toJson(p);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        Person p = fc.getPerson(body.get("id").getAsInt());

        if (body.has("firstName")) {
            p.setFirstName(body.get("firstName").getAsString());
        }
        if (body.has("lastName")) {
            p.setLastName(body.get("lastName").getAsString());
        }
        if (body.has("phoneNumber")) {
            p.setEmail(body.get("email").getAsString());
        }

        fc.editPerson(p);

        return new Gson().toJson(p);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String deletePerson(@PathParam("id") int id) {
        Person p = fc.deletePerson(id);

        return new Gson().toJson(p);
    }
}