package com.redonz.hb.peoplerepu.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redonz.hb.peoplerepu.TimeDeserializer;
import com.redonz.hb.peoplerepu.dao.CommentEntityDAO;
import com.redonz.hb.peoplerepu.entity.CommentEntity;
import com.redonz.hb.peoplerepu.entity.CommentEntityPK;
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
import java.sql.Time;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-21.
 * dinuka.nadeeshan1993@gmail.com
 */

@Path("/comment")
public class CommentWebService {

    @Context
    private UriInfo context;

    //TODO
    @EJB
    private CommentEntityDAO entityDAO;

    private Gson gson;

    /**
     * Creates a new instance of UserWebService
     */
    public CommentWebService() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").registerTypeAdapter(Time.class, new TimeDeserializer()).create();
    }

    @POST
    @Path("/add")
    @Produces("application/json")
    @Consumes("application/json")
    public String add(String json) {
        //TODO
        CommentEntity e = gson.fromJson(json, CommentEntity.class);
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
        entityDAO.delete(new CommentEntityPK(Long.parseLong(jsonObj.get("id").toString()), Long.parseLong(jsonObj.get("postId").toString())));
        return "Deleted...";
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    @Consumes("application/json")
    public String update(String json) {
        //TODO
        CommentEntity e = gson.fromJson(json, CommentEntity.class);
        entityDAO.update(e);
        return "Updated...";
    }
}
