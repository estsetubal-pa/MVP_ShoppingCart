/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp.presenter;


import mvp.model.Product;
import mvp.model.ShoppingCart;
import mvp.model.ShoppingCartException;
import mvp.view.ShoppingCartView;

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
            view.updateView(new ArrayList(model.getProducts()),String.valueOf(model.getTotal()));


        } catch (ShoppingCartException e) {
            view.showError(e.getMessage());
            view.clearInput();
        }
        catch (NumberFormatException e) {
            view.showError("it is not a number");
        }
        
    }

}
