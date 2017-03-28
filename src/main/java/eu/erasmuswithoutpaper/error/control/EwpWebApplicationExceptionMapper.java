package eu.erasmuswithoutpaper.error.control;

import eu.erasmuswithoutpaper.api.architecture.ErrorResponse;
import eu.erasmuswithoutpaper.api.architecture.MultilineString;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EwpWebApplicationExceptionMapper implements ExceptionMapper<EwpWebApplicationException> {
    @Override
    public Response toResponse(EwpWebApplicationException exception) 
    {
        ErrorResponse errorResponse = new ErrorResponse();
        MultilineString message = new MultilineString();
        message.setValue(exception.getMessage());
        errorResponse.setDeveloperMessage(message);
        
        return Response.status(exception.getResponse().getStatus()).type(MediaType.APPLICATION_XML).entity(errorResponse).build();  
    }
}
