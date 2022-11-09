package com.cartrest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cartrest.database.DatabaseConnection;
import com.cartrest.model.Item;

public class CartService {
    private DatabaseConnection connector = new DatabaseConnection();
    
    public List<Item> getCartItems(int UserId) throws Exception{
        Connection connection = connector.getConnection();
        
        String query = "SELECT * FROM cartitems WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, UserId);
            
            ResultSet rs = statement.executeQuery();
      
            return getItemList(rs);
        }
    }
    
    private List<Item> getItemList(ResultSet rs) throws SQLException{
            
            List<Item> items = new ArrayList<>();
            
            while(rs.next()) {
                
                Item item = new Item();
                
                item.setId(rs.getInt("id"));
                item.setPid(rs.getInt("pid"));
                item.setName(rs.getString("name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getInt("price"));
                
                items.add(item);
            }
            
            return items;
        }
    
    public boolean deleteItem(int userId, int productId){
        Connection connection = connector.getConnection();
        
        String query = "DELETE FROM cartitems WHERE uid = ? and pid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            
            statement.execute();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    
    
}
