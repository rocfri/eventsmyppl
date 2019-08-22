package io.eventsmyppl.test.controller;

import io.eventsmyppl.EventsMyPplApplication;
import io.restassured.RestAssured;
import io.eventsmyppl.controller.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = EventsMyPplApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class BackendControllerTest {

	@LocalServerPort
	private int port;

	@Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }
	@Test 
	public void getUserEmail() {
			when().get("/api/login")
		.then().statusCode(HttpStatus.SC_OK);
			
	}
    @Test
	public void trueTest(){
		assertEquals(6,6);
	}
}
