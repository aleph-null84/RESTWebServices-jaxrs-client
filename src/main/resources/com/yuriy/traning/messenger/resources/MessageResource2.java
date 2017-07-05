package com.yuriy.traning.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yuriy.traning.messenger.model.Message;
import com.yuriy.traning.messenger.service.MessageService;

@Path("/messages2")
public class MessageResource2 {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		return "Hello World!";
	}
}
