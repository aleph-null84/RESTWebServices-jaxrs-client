package com.yuriy.traning.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.yuriy.traning.messenger.model.Message;

public class RestApiClient1 {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		Response response = client.target("http://localhost:8080/jaxrs-client/webapi/messages/1")
				                  .request()
				                  .get();
		
		Message message = response.readEntity(Message.class);
		
		System.out.println(message.getMessage());

	}

}
