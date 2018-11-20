package runtime;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
@RequestScoped
public class Resource {

    @Inject
    @RestClient
    FacadeService facadeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {

        return "test";
    }

}
