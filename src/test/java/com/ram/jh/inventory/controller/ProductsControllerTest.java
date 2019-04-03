package com.ram.jh.inventory.controller;

import com.ram.jh.inventory.Application;
import com.ram.jh.inventory.model.Product;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductsControllerTest {

    protected MockMvc mvc;

    private static final String URL = "/v1/categories/100/products";
    private static final String PRODUCT_URL = "http://localhost:8080/v1/categories/100/products";

    @Before
    public  void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void contextLoads() throws Exception {
    }

    @Test
    public void test_products_with_reduced_price1(){

        //ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/v1/categories/100/products", String.class);
        //assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

    @Test
    public void test_products_with_reduced_price() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.length() > 0);
    }
}
