package com.redhat.client;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.redhat.model.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/public/v2/users")
@RegisterRestClient
@RegisterClientHeaders
public interface UserClient {
 
    @GET
    List<User> getUsers();
    @GET
    @Path("/{id}")
    User getByID(@PathParam Integer id);

}
