package com.example.CheckAccount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckTests {

    @Autowired
    private TestRestTemplate restTemplate;

    /*@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/check/getRiskByID/{id}", String.class, "123123");
		assertThat(body).isEqualTo("123123");
	}*/

    /*@Test
    public void testTest(){
        assertEquals("200", restTemplate.getForObject("http://localhost:8080/check/test", String.class));
    }*/
}
