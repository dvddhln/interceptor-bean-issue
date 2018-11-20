package runtime;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class FacadeErrorMapper implements ResponseExceptionMapper<Exception> {

    @Override
    public boolean handles(int statusCode, MultivaluedMap<String, Object> headers) {

        Response.Status status = Response.Status.fromStatusCode(statusCode);
        return status.getFamily() == Response.Status.Family.CLIENT_ERROR
                || status.getFamily() == Response.Status.Family.SERVER_ERROR;
    }

    @Override
    public Exception toThrowable(Response response) {

        return new RuntimeException("run time exception");
    }
}
