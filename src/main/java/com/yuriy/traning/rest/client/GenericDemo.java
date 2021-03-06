package com.yuriy.traning.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.yuriy.traning.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		List<Message> messages = client.target("http://localhost:8080/jaxrs-client/webapi/")
				                       .path("messages")
				                       .queryParam("year", 2015)
				                       .request(MediaType.APPLICATION_JSON)
				                       .get(new GenericType<List<Message>>() {});
		System.out.println(messages);

	}

}