package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.dao.UserEntityDAO;
import com.redonz.hb.peoplerepu.entity.UserEntity;
import org.json.simple.parser.ParseException;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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
//    @Inject
    private UserEntityDAO controllerEntity;

    /**
     * Creates a new instance of UserWebService
     */
    public UserWebService() {
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
    public String authUser(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        return controllerEntity.authenticateUser(userName, password);
//        return controllerEntity.authenticateUser(user.getUserName(), user.getPassword());
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
//    public String addUser(UserEntity user) {
    public String addUser(String userJson) throws ParseException {

//        return  userJson.get("fName").toString()+ " " + userJson.get("userName").toString();

        return userJson;
//        UserEntity user = new UserEntity();
//        controllerEntity.insert(user);
//        System.out.println("User Saved...=========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        return "User Saved...=========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(UserEntity user) {
        controllerEntity.delete(user.getId());
        return "Deleted...";
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(UserEntity user) {
        controllerEntity.update(user);
        return "Updated...";
    }


    @GET
    @Path("/test/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@PathParam("id") String id) {

        return "Hellow... " + id;
    }
}
