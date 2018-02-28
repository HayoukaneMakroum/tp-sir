package restRessources;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.PersonDAO;
import domain.Heater;
import domain.Home;
import domain.Person;

import java.util.List;

@Path("/people")
public class PersonneRessource {
	
	@GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setName("toto");
        Heater h1 = new Heater();
        h1.setName("500w");
        Heater h2 = new Heater();
        h2.setName("600w");
        return h;
    }

    @GET
    @Path("/getPeople")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPeople() {
        List<Person> list = new PersonDAO().readAll();
        return list;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPersonInJSON(Person personne) {
        PersonDAO personDAO=new PersonDAO();
        personDAO.create(personne);
        String result = "Person saved : " +personne;
        return Response.status(201).entity(result).build();

    }






}
