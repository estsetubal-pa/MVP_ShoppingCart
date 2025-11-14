/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp_supervisioning.view;


import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import mvp_supervisioning.model.Product;
import mvp_supervisioning.model.ShoppingCart;
import mvp_supervisioning.presenter.ShoppingCartPresenter;


/**
 *
 * @author brunomnsilva
 */
public class ShoppingCartUI implements ShoppingCartView {

    private final VBox vBox = new VBox();
    //controlos
    private TextField txtInputId;
    private Button btAddProduct;
    private Button btRemoveProduct;
    private ListView<Product> listProductsView;
    private Label lblError;
    
    private Label lblCount;

    private ShoppingCart model;

    //modelo

    
    public ShoppingCartUI(ShoppingCart model) {
        initComponents();
        this.model=model;

    }
    


    
    private void initComponents() {
        vBox.setPadding(new Insets(5,5,5,5));
        this.txtInputId = new TextField();
        this.btAddProduct = new Button("Add");
        this.btRemoveProduct = new Button("Remove");
        this.listProductsView = new ListView<>(model.getProducts());
        lblError = new Label();
        lblCount = new Label("0");
        databindingTotalCost(lblCount);
        HBox firstRow = new HBox(txtInputId,btAddProduct,btRemoveProduct, new Label("Total Value"),lblCount);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(8);

        vBox.getChildren().addAll(firstRow, listProductsView, lblError);
    }

    /**
     * Binds the label's text to the total cost of the shopping cart.
     *
     * The binding creates a DoubleBinding whose value is recomputed
     * every time the products list changes (add/remove). The binding
     * calls model.getTotal() to calculate the current total and then
     * formats it as a string with two decimal places.
     *
     * @param lblCount The label that will display the total cost.
     */
    private void databindingTotalCost(Label lblCount) {
        lblCount.textProperty().bind(
                Bindings.createDoubleBinding(
                        () -> (double) model.getTotal(),   // call your method
                        model.getProducts()                // dependency: the ObservableList
                ).asString("%.2f")                    // format as string with 2 decimal places
        );
    }


    @Override
    public void setTriggers(ShoppingCartPresenter controller) {
        btAddProduct.setOnAction((ActionEvent event) -> {
            controller.doAddProduct();
        });
        btRemoveProduct.setOnAction((ActionEvent event) -> {
            controller.doRemoveProduct();
        });
    }

    @Override
    public Product getProductSelected() {
        Product p= listProductsView.getSelectionModel().getSelectedItem();
        return p;

    }


    @Override
    public void showError(String msg) {
        lblError.setText(msg);
    }



    @Override
    public String getInputProductId() {
        return txtInputId.getText().trim();
    }


    @Override
    public void clearInput() {
        txtInputId.setText("");
    }

    @Override
    public void clearError(){
        this.lblError.setText("");
    }

    public Pane getPane(){
        return this.vBox;
    }
}
