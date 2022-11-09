package com.cartrest.resources;

import java.sql.SQLException;
import java.util.List;

import com.cartrest.model.Item;
import com.cartrest.services.CartService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cartitems")
@Produces(value = {MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
public class CartResource {
    
    private CartService cartService = new CartService();
    
    @GET
    @Path("/{userId}")
    public List<Item> getItems(@PathParam("userId") int userId) throws SQLException {
        return cartService.getCartItems(userId);
    }
    
    @DELETE
    @Path("/{userId}/{id}")
    public boolean deleteItem(@PathParam("userId") int userId, @PathParam("id") int id){
        return cartService.deleteItem(userId, id);
    }
    
    @DELETE
    @Path("/{userId}")
    public boolean deleteAllItems(@PathParam("userId") int userId) {
        return cartService.deleteAllItems(userId);
    }
    
    @POST
    @Path("/{userId}")
    public boolean insertItem(@PathParam("userId") int userId, Item item)throws SQLException{
        return cartService.inserItem(userId, item);
    }
    
    @PUT
    @Path("/{userId}")
    public boolean updateOrders(@PathParam("userId") int userId, List<Item> items)throws SQLException{
        return cartService.updateMyOrder(userId, items);
    }
}
