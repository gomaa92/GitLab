/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.ResultSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gom3a
 */
public class GuiDataBase extends Application {
    // ahmed start here
   
    boolean status = false;
    ResultSet resultSet = null;
    GuiBase root;

    public GuiDataBase() {

        root = new GuiBase();
        resultSet = root.dataBaseConnection();
    }
    
    // islam start here
     @Override
    public void start(Stage primaryStage) {
            Scene scene = new Scene(root);

        primaryStage.setTitle("DAataBase");
        primaryStage.setScene(scene);
        primaryStage.show();
}
    
     public static void main(String[] args) {
        launch(args);
    }

}
