package com.example.fantaskbackend.controller;

/*
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
*/

import com.example.fantaskbackend.CrossSearchInput;
import com.example.fantaskbackend.CrossSearchItem;
import com.example.fantaskbackend.service.AllService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemRESTControllerTest.class)
class ItemRESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AllService allService;

    @Test
    public void searchAllShouldReturnCrossSearchItemsTest() throws Exception {

        // https://www.baeldung.com/spring-boot-testing
        // https://spring.io/guides/gs/testing-web/
        // https://stackabuse.com/guide-to-unit-testing-spring-boot-rest-apis/
        List<CrossSearchItem> items = new ArrayList<>();

        List<String> authors = new ArrayList<>();

        authors.add("Bjarne");
        authors.add("Søren");
        authors.add("Mary");
        authors.add("Tobias");

        CrossSearchItem book = new CrossSearchItem(23L, authors, "How to Host a Murder", "Birds Flying High", null, "12", "book");
        items.add(book);

        when(allService.searchCrossAll(any())).thenReturn(items);

        CrossSearchInput crossSearchInput = new CrossSearchInput("b", "",false, false, false,false, false, false, "7");

        this.mockMvc
                .perform(post("http://localhost:8080/category/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(crossSearchInput)))
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("Birds Flying High"))
                );

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
                */
    }
}