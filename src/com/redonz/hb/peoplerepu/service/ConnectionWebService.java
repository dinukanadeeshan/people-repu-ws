package com.redonz.hb.peoplerepu.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redonz.hb.peoplerepu.dao.ConnectionEntityDAO;
import com.redonz.hb.peoplerepu.entity.ConnectionEntity;
import com.redonz.hb.peoplerepu.entity.ConnectionEntityPK;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@Path("/connection")
public class ConnectionWebService {

    @Context
    private UriInfo context;

    //TODO
    @EJB
    private ConnectionEntityDAO entityDAO;

    private Gson gson;

    /**
     * Creates a new instance of UserWebService
     */
    public ConnectionWebService() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    @POST
    @Path("/add")
    @Produces("application/json")
    @Consumes("application/json")
    public String add(String json) {
        //TODO
        ConnectionEntity e = gson.fromJson(json, ConnectionEntity.class);
        entityDAO.insert(e);
        return "Saved...";
    }

    @POST
    @Path("/delete")
    @Produces("application/json")
    @Consumes("application/json")
    public String delete(String json) throws ParseException {
        //TODO
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(json);
        entityDAO.delete(new ConnectionEntityPK(Long.parseLong(jsonObj.get("user1").toString()), Long.parseLong(jsonObj.get("user2").toString())));
        return "Deleted...";
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    @Consumes("application/json")
    public String update(String json) {
        //TODO
        ConnectionEntity e = gson.fromJson(json, ConnectionEntity.class);
        entityDAO.update(e);
        return "Updated...";
    }
}
