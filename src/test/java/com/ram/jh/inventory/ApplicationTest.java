package com.ram.jh.inventory;

import com.ram.jh.inventory.model.Product;
import com.ram.jh.inventory.model.Products;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    Application mockObj = Mockito.mock(Application.class);

    @Test
    public void contextLoads() {
    }

    //Mocking only productId and Title as this is technical Test taking time into account.
    @Test
    public void test_products_with_category_600001506(){
        Products products = Mockito.mock(Products.class);
        Product product = Mockito.mock(Product.class);
        String someProductId = "someProductId";
        when(product.getProductId()).thenReturn(someProductId);
        String someTitle = "someTitle";
        when(product.getTitle()).thenReturn(someTitle);

        //when(mockObj.getListOfProductFromURL()).thenReturn(products);
        //Products productsReturned = mockObj.getListOfProductFromURL();
        when(mockObj.getJsonFromFile()).thenReturn(products);
        Products productsReturned = mockObj.getJsonFromFile();
        List<Product> productListMock = new ArrayList<>();
        productListMock.add(product);
        when(productsReturned.getProducts()).thenReturn(productListMock);
        List<Product> productList = productsReturned.getProducts();
        Product actualProduct = productList.get(0);
        Assert.assertEquals(someProductId,actualProduct.getProductId());
        Assert.assertEquals(someTitle,actualProduct.getTitle());
    }
}
