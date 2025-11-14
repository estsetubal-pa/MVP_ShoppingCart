package mvp.view;

import javafx.scene.layout.Pane;
import mvp.presenter.ShoppingCartPresenter;
import mvp.model.Product;
import java.util.List;

/**
 * Represents the View component in an MVP architecture for the Shopping Cart.
 * This interface defines all interactions that the Presenter can perform on
 * the View, such as retrieving user input, updating UI elements, showing
 * messages, and registering event handlers.
 *
 * Implementations of this interface should contain the actual JavaFX controls.
 * The Presenter interacts with the View solely through these methods.
 *
 * author: patricia.macedo
 */
public interface ShoppingCartView {

    /**
     * Retrieves the product ID entered by the user in the input field.
     *
     * @return the product ID as a String
     */
    String getInputProductId();

    /**
     * Clears the input field used for entering the product ID.
     */
    void clearInput();

    /**
     * Displays an error message to the user.
     * Typically used for validation errors or failed operations.
     *
     * @param msg the error message to display
     */
    void showError(String msg);

    /**
     * Registers the Presenter so that UI events (button clicks, selections,
     * etc.) can be forwarded from the View to the Presenter.
     *
     * @param controller the presenter responsible for handling user actions
     */
    void setTriggers(ShoppingCartPresenter controller);

    /**
     * Returns the product currently selected in the UI (for example,
     * from a list or table).
     *
     * @return the selected Product, or null if no product is selected
     */
    Product getProductSelected();

    /**
     * Updates the visual components of the view with the provided list
     * of products and the computed total cost.
     *
     * @param listProducts the list of products to display
     * @param total the total cost to display in the UI
     */
    void updateView(List<Product> listProducts, String total);

    /**
     * Clears any error message currently displayed in the view.
     */
    void clearError();

    /**
     * Returns the root JavaFX Pane that represents this view.
     * This allows embedding the view inside other layouts or scenes.
     *
     * @return the root Pane of the view
     */
    Pane getPane();
}

