package com.ram.jh.inventory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.jh.inventory.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ProductsService service; //= new ProductsServiceImpl();

    private static final String URL = "/v1/categories/100/products";
    private static final String PRODUCT_URL = "http://localhost:8080/v1/categories/100/products";

    @Test
    public void shouldReturn200FromService() throws Exception {

        List<ReducedProductPrice> productList = createReducedProductList();
        when(service.getReducedPriceList(Mockito.anyString())).thenReturn(createReducedProductList());
        Assert.assertEquals(productList,service.getReducedPriceList("showwasnow"));

    }

    private List<ReducedProductPrice> createReducedProductList() {

        ColorSwatch colorSwatch = new ColorSwatch("Wine", "Red", "237494589");
        Price price = new Price("149.00", "89.00", "", "74.00", "", "GBP");
        Product product = new Product(
                        "3428696",
                        "Hobbs Kiona Dress, Green",
                        Collections.singletonList(colorSwatch), price);

        ReducedProductPrice reducedProductPrice = new ReducedProductPrice(product, "showwasnow");
        return Collections.singletonList(reducedProductPrice);
    }

    private String createJson(List<ReducedProductPrice> reducedProductList) {
        try {
            return new ObjectMapper().writeValueAsString(Collections.singletonList(reducedProductList));
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
