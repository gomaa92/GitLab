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

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



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

        try {
            resultSet.first();
            showResult();
        } catch (SQLException ex) {
            Logger.getLogger(GuiDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        root.first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent value) {
                try {
                    //  resultSet = root.obtainResultSet();
                    if (resultSet.first()) {
                        showResult();
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        root.next.setOnAction(value -> {

            try {
                if (resultSet.next()) {
                    showResult();
                } else {
                    resultSet.previous();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        root.previous.setOnAction(value -> {
            try {
                if (resultSet.previous()) {
                    showResult();
                } else {
                    resultSet.next();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

        });

      
        Scene scene = new Scene(root);

        primaryStage.setTitle("DAataBase");
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