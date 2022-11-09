package com.cartrest.resources;

import java.util.List;

import com.cartrest.model.Order;
import com.cartrest.services.OrderService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/orders")
public class OrderResource {
     
    private OrderService orderService = new OrderService();
    
    @GET
    @Path("/{userId}")
    public List<Order> getItems(@PathParam("userId") int userId) throws Exception {
        return orderService.getOrdertems(userId);
    }
}
