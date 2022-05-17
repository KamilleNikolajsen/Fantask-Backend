package com.example.fantaskbackend.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ItemRESTControllerTest {

    //https://www.baeldung.com/integration-testing-a-rest-api

    /*
    @Test
    public void error404() throws IOException, ClientProtocolException {

        // Given
        HttpUriRequest httpUriRequest = new HttpGet("localhost:8080/test");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpUriRequest);

        // Then
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

     */


}