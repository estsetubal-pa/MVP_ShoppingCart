/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp_supervisioning.presenter;


import mvp_supervisioning.model.Product;
import mvp_supervisioning.model.ShoppingCart;
import mvp_supervisioning.model.ShoppingCartException;
import mvp_supervisioning.view.ShoppingCartView;

import java.util.ArrayList;

/**
 *
 * @author patriciamacedo
 */
public class ShoppingCartPresenter {
    

    private final ShoppingCartView view;
    private final ShoppingCart model;

    
    public ShoppingCartPresenter(ShoppingCartView view, ShoppingCart model) {
        this.view = view;
        this.model = model;
        
        view.setTriggers(this);

    }


    public void doAddProduct() {
        
        String id = view.getInputProductId();
        
        try {
            model.addProduct(Integer.parseInt(id));
            view.clearError();
            view.clearInput();


        } catch (ShoppingCartException e) {
            view.showError(e.getMessage());
            view.clearInput();
        }
        catch (NumberFormatException e) {
            view.showError("it is not a number");
        }
        
    }

    public void doRemoveProduct() {
        Product p= view.getProductSelected();
        if(p!=null) {
            model.removeProduct(p);
               view.clearError();
        }
        else
            view.showError("No product selected");
    }
}
