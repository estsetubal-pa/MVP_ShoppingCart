/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp.view;


import javafx.scene.layout.Pane;
import mvp.presenter.ShoppingCartPresenter;
import mvp.model.Product;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author brunomnsilva
 */
public class ShoppingCartUI implements ShoppingCartView {

    private final VBox vBox = new VBox();
    //controlos
    private TextField txtInputId;
    private Button btAddProduct;

    private ListView<Product> listProductsView;
    private Label lblError;
    
    private Label lblCount;


    //modelo

    
    public ShoppingCartUI() {
        initComponents();
        updateView(new ArrayList(), "0");
    }
    

    public void updateView(List<Product> listProducts, String total) {
            this.listProductsView.getItems().clear();
            listProductsView.getItems().addAll(listProducts);
            lblCount.setText(""+ total);
    }
    
    private void initComponents() {
        vBox.setPadding(new Insets(5,5,5,5));
        this.txtInputId = new TextField();
        this.btAddProduct = new Button("Add");
        this.listProductsView = new ListView<>();
        lblError = new Label();
        
        lblCount = new Label("0");
        
        HBox firstRow = new HBox(txtInputId,btAddProduct, new Label("Total Value"),lblCount);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(8);

        vBox.getChildren().addAll(firstRow, listProductsView, lblError);
    }
    @Override
    public void setTriggers(ShoppingCartPresenter controller) {
        btAddProduct.setOnAction((ActionEvent event) -> {
            controller.doAddProduct();
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
