package com.redonz.hb.peoplerepu.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redonz.hb.peoplerepu.dao.*;
import com.redonz.hb.peoplerepu.entity.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-12.
 * dinuka.nadeeshan1993@gmail.com
 */
@Path("user")
public class UserWebService {
    @Context
    private UriInfo context;

    @EJB
    private UserEntityDAO entityDAO;

    @EJB
    private UserHasSkillEntityDAO userHasSkillEntityDAO;

    @EJB
    private UserHasProfessionEntityDAO userHasProfessionEntityDAO;

    @EJB
    private RequestEntityDAO requestEntityDAO;

    @EJB
    private ConnectionEntityDAO connectionEntityDAO;



    private Gson gson;

    /**
     * Creates a new instance of UserWebService
     */
    public UserWebService() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    /**
     * Retrieves representation of an instance of
     * com.redonz.hb.peoplerepu.service.service.UserWebService
     *
     * @param userName
     * @param password
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/authUser")
    @Produces(MediaType.TEXT_PLAIN)
//    public String authUser(User user) {
    public boolean authUser(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        return entityDAO.authenticateUser(userName, password);
//        return entityDAO.authenticateUser(user.getUserName(), user.getPassword());
    }

    /**
     * PUT method for updating or creating an instance of UserWebService
     *
     * @param
     * @return
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(String userJson) throws ParseException {

//        return  userJson.get("fName").toString()+ " " + userJson.get("userName").toString();
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(userJson);
//


        UserEntity u = gson.fromJson(userJson, UserEntity.class);
        entityDAO.insert(u);
        return u.toString();
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(String userJson) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject user = (JSONObject) parser.parse(userJson);
        entityDAO.delete(Long.parseLong(user.get("id").toString()));
        return "Deleted...";
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(String userJson) {

        UserEntity u = gson.fromJson(userJson, UserEntity.class);
        entityDAO.update(u);
        return "Updated...";
    }

    @POST
    @Path("/add/skill")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addSkill(String userJson) throws ParseException {

        UserHasSkillEntity u = gson.fromJson(userJson, UserHasSkillEntity.class);
        userHasSkillEntityDAO.insert(u);
        return "Skill added to user...";
    }

    @POST
    @Path("/add/profession")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addProfession(String userJson) throws ParseException {

        UserHasProfessionEntity u = gson.fromJson(userJson, UserHasProfessionEntity.class);
        userHasProfessionEntityDAO.insert(u);
        return "Profession added to user...";
    }

    @POST
    @Path("/request/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendRequest(String userJson) throws ParseException {

        RequestEntity u = gson.fromJson(userJson, RequestEntity.class);
        requestEntityDAO.insert(u);
        return "Request send...";
    }

    @POST
    @Path("/request/accept")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String acceptRequest(String userJson) throws ParseException {

        RequestEntity u = gson.fromJson(userJson, RequestEntity.class);
        requestEntityDAO.delete(new RequestEntityPK(u.getSender(), u.getReciever()));
        ConnectionEntity connectionEntity = new ConnectionEntity();
        connectionEntity.setUser1(u.getSender());
        connectionEntity.setUser2(u.getReciever());
        connectionEntity.setRecomendedPeople(0l);
        connectionEntity.setStartedDate(new java.sql.Date(new Date().getTime()));
        connectionEntityDAO.insert(connectionEntity);
        return "Request send...";
    }
}
