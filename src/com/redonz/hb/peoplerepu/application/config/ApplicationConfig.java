/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.application.config;

import com.redonz.hb.peoplerepu.service.*;

import javax.ws.rs.core.Application;
import java.util.Set;


/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(UserWebService.class);
        resources.add(PostWebService.class);
        resources.add(CommentWebService.class);
        resources.add(ConnectionWebService.class);
        resources.add(ProfessionWebService.class);
        resources.add(ReputationWebService.class);
        resources.add(SkillWebService.class);
        resources.add(TaskWebService.class);
        resources.add(UpdateWebService.class);
        return resources;
    }


}
