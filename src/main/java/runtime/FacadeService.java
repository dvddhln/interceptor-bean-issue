package runtime;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RegisterProvider(FacadeErrorMapper.class)
@RegisterRestClient
@Timeout
@Path("/")
public interface FacadeService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/rest/test")
    String test();


}
