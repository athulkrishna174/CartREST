package com.cartrest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cartrest.database.DatabaseConnection;
import com.cartrest.model.Order;

public class OrderService {
private DatabaseConnection connector = new DatabaseConnection();
    
    public List<Order> getOrdertems(int UserId) throws Exception{
        Connection connection = connector.getConnection();
        
        String query = "SELECT * FROM orders WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, UserId);
            
            ResultSet rs = statement.executeQuery();
      
            return getItemList(rs);
        }
    }
    
    private List<Order> getItemList(ResultSet rs) throws SQLException{
            
            List<Order> orders = new ArrayList<>();
            
            while(rs.next()) {
                
                Order order = new Order();
                
                order.setId(rs.getInt("id"));
                order.setPid(rs.getInt("pid"));
                order.setName(rs.getString("name"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getInt("price"));
                order.setDate(rs.getString("date"));
                
                orders.add(order);
            }
            
            return orders;
        }
}
