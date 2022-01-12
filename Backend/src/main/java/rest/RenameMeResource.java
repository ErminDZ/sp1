package rest;

import com.google.gson.Gson;
import dtos.BoatDTO;
import entities.Boat;
import entities.Owner;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.PathParam;

import facades.MainFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class RenameMeResource {


    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MainFacade MAIN_FACADE = MainFacade.getMainFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public List<User> GetInfoFromUser() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <User> query = em.createQuery("SELECT u from User u where u.userName=:username", entities.User.class);
        List<User> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("owner")
    public List<Owner> ShowAllOwners() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Owner> query = em.createQuery("SELECT o from Owner o", Owner.class);
        List<Owner> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("boat")
    public List<Boat> AddBoatToHarbour(String name) throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Boat> query = em.createQuery("SELECT b, b.harbour from Boat b join FETCH b.harbour h where h.name=:name ", entities.Boat.class);
        List<Boat> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Path("AddBoat")
    public String AddBoat(String jsonString) throws SQLException {
        System.out.println(jsonString);
        BoatDTO bDTO = gson.fromJson(jsonString, BoatDTO.class);
        System.out.println("id: " + bDTO.getId() + " brand: " + bDTO.getBrand() + " make: " + bDTO.getMake() + " name: " + bDTO.getName()+ " image: " + bDTO.getImage()+ " harbour_id: " + bDTO.getId());
        MAIN_FACADE.CreateBoat(bDTO);
        return "{}";
    }


    public void main(String[] args) throws Exception{
        ShowAllOwners();
        AddBoatToHarbour("name");

    }
}