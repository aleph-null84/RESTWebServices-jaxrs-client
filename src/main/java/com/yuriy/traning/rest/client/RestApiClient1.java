package com.yuriy.traning.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yuriy.traning.messenger.model.Message;

public class RestApiClient1 {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		WebTarget baseTarget = client.target("http://localhost:8080/jaxrs-client/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");

		/*
		 * Response response =
		 * client.target("http://localhost:8080/jaxrs-client/webapi/messages/1")
		 * .request() .get();
		 * 
		 * Message message = response.readEntity(Message.class);
		 * 
		 * System.out.println(message.getMessage());
		 */

		Message message1 = singleMessageTarget.resolveTemplate("messageId", "1")
				                              .request(MediaType.APPLICATION_JSON)
				                              .get(Message.class);

		Message message2 = singleMessageTarget.resolveTemplate("messageId", "2")
				                              .request(MediaType.APPLICATION_JSON)
				                              .get(Message.class);
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());

		Message newMessage = new Message(4, "My New message from JAX-RS client", "aleph null");
		Response postResponse = messagesTarget.request()
				                              .post(Entity.json(newMessage));
		if (postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());

	}

}
