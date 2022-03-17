package com.redhat.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.redhat.model.User;
import java.util.List;

@Path("/users")
public class UserResource {
    

    @Inject
    @RestClient
    UserClient client;

    @GET
    public List<User> id() {
        return client.getUsers();
    }

    @GET
    @Path("/id/{id}")
    public User id(@PathParam Integer id, @Context HttpHeaders requestHeaders) {
        System.out.println(requestHeaders);

        return client.getByID(id);
    }

}
