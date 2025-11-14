package mvp_supervisioning;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mvp_supervisioning.view.ShoppingCartView;

/**
 * @author brunomnsilva
 */
public class Main extends Application {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 250;

    @Override
    public void start(Stage primaryStage) {


        ShoppingCartView view = FactoryMVP.create();
        BorderPane window = new BorderPane();
        window.setCenter(view.getPane());

        Scene scene = new Scene(window, WIDTH, HEIGHT);

        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
