package com.cartrest.resources;

import java.sql.SQLException;
import java.util.List;

import com.cartrest.model.Product;
import com.cartrest.services.ProductsService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/products")
@Produces(value = {MediaType.APPLICATION_JSON})
public class ProductResource {
    
    private ProductsService productsService = new ProductsService();
    
    @GET
    public List<Product> getProducts() throws SQLException{
        return productsService.getProducts();
    }
    
    @GET
    @Path("/{productId}")
    public Product getProduct(@PathParam("productId") long productId) throws SQLException {
        return productsService.getProduct(productId);
    }
    
}
