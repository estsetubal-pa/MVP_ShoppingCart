/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp_supervisioning.model;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author brunomnsilva
 */
public class ShoppingCart  {
    
    private String name;
    private ObservableList<Product> products; //To make Databinding with the View

    public ShoppingCart(String name) {
        this.name = name;
        products = FXCollections.observableList(new ArrayList<>());//To make Databinding with the View
    }
    
    public void addProduct(Product p) {
        products.add(p);

    }

    public void addProduct(int id) throws ShoppingCartException {
        Product p= ProductListFactory.createProduct(id);
        addProduct(p);
    }
    
    public void removeProduct(Product p) {
        products.remove(p);

    }
    public Product lastProductAdded(){
          return products.get(products.size()-1);

    }
    public String getName() {
        return name;
    }
    
    public ObservableList getProducts() {
        return products;
    }

    public float getTotal() {
        float total=0.0f;
        for(Product p: products)
            total+=p.getCost();
        return total;
    }


}
