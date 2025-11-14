/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp_supervisioning.view;

import javafx.scene.layout.Pane;
import mvp_supervisioning.model.Product;
import mvp_supervisioning.presenter.ShoppingCartPresenter;

import java.util.List;

/**
 *
 * @author patricia.macedo
 */
public interface ShoppingCartView {

    /**
     * Returns the product ID entered by the user (usually from a text field).
     *
     * @return the product ID as a String
     */
    String getInputProductId();

    /**
     * Clears the user input field.
     */
    void clearInput();

    /**
     * Displays an error message to the user
     * (e.g., invalid ID, product not found, etc.).
     *
     * @param msg the error message to display
     */
    void showError(String msg);

    /**
     * Registers the presenter so the view can notify it
     * when UI events occur (button clicks, selections, etc.).
     *
     * @param controller the presenter responsible for handling events
     */
    void setTriggers(ShoppingCartPresenter controller);

    /**
     * Returns the product currently selected in the UI
     * (for instance, from a ListView or TableView).
     *
     * @return the selected Product, or null if none is selected
     */
    Product getProductSelected();

    /**
     * Clears any error message currently shown in the view.
     */
    void clearError();

    /**
     * Returns the root UI container of the view.
     * This allows the view to be embedded in another scene or layout.
     *
     * @return the root Pane of the view
     */
    Pane getPane();
}
