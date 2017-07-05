package com.yuriy.traning.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class RestApiClient1 {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		Response response = client.target("http://localhost:8080/jaxrs-client/webapi/messages/1")
				                  .request()
				                  .get();
		
		System.out.println(response);

	}

}
