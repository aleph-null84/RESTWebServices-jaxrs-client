package com.yuriy.traning.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.yuriy.traning.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),
        		                                     Status.NOT_FOUND.getStatusCode(),
        		                                     "https://github.com/aleph-null84/RESTWebServices-messenger");
		return Response.status(Status.NOT_FOUND)
				       .entity(errorMessage)
				       .build();
	}

}
