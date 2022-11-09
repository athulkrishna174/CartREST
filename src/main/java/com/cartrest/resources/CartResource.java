package com.cartrest.resources;

import java.util.List;

import com.cartrest.model.Item;
import com.cartrest.services.CartService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cartitems")
@Produces(value = {MediaType.APPLICATION_JSON})
public class CartResource {
    
    private CartService cartService = new CartService();
    
    @GET
    @Path("/{userId}")
    public List<Item> getItems(@PathParam("userId") int userId) throws Exception {
        return cartService.getCartItems(userId);
    }
    
    @DELETE
    @Path("/{userId}/{productId}")
    public boolean deleteItem(@PathParam("userId") int userId, @PathParam("productId") int productId) throws Exception{
        return cartService.deleteItem(userId, productId);
    }

}
