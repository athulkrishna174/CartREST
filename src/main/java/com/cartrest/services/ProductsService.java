package com.cartrest.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cartrest.database.DatabaseConnection;
import com.cartrest.model.Product;

public class ProductsService {
    
    private DatabaseConnection connector = new DatabaseConnection();
    
    public List<Product> getProducts() throws SQLException{
        
        Connection connection = connector.getConnection();
        
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
      
            return getProductList(rs);
        }
    }

    private List<Product> getProductList(ResultSet rs) throws SQLException{
        
        List<Product> products = new ArrayList<>();
        int pid = 1;
        
        while(rs.next()) {
            
            Product product = new Product();
            
            product.setPid(pid);
            pid++;
            
            product.setProductName(rs.getString("pname"));
            product.setPrice(rs.getString("price"));
            product.setImageUri(rs.getString("image"));
            
            products.add(product);
        }
        
        return products;
    }
    
    public Product getProduct(long pid) throws SQLException {
        
        List<Product> products = getProducts();
        
        for(Product product : products)
            if(product.getPid() == pid) return product;

        
        return null;
    }
}
