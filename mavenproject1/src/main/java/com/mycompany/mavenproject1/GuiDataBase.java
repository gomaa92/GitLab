/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.stage.Stage;

public class GuiDataBase extends Application {

    boolean status = false;
    ResultSet resultSet = null;
    GuiBase root;

    public GuiDataBase() {

        root = new GuiBase();
        resultSet = root.dataBaseConnection();
    }

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

        root.newRow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent value) {
                if (!status) {

                    root.id.setText("");
                    root.fName.setText("");
                    root.mName.setText("");
                    root.lName.setText("");
                    root.eMail.setText("");
                    root.phone.setText("");

                    status = true;

                }
            }
        });

        root.update.setOnAction((event) -> {
            try {
                if (!status) {

                    updateRow();
                    resultSet.updateRow();
                } else {
                    resultSet.moveToInsertRow();

                    updateRow();
                    resultSet.insertRow();
                    status = false;

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        root.delete.setOnAction(value -> {
            try {
                if (!status) {
                    resultSet.deleteRow();
                    resultSet.first();
                    showResult();
                } else {
                    System.out.println("please select row");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        root.last.setOnAction(value -> {

            try {
                if (resultSet.last()) {
                    root.id.setText(resultSet.getInt(1) + "");
                    root.fName.setText(resultSet.getString(2));
                    root.mName.setText(resultSet.getString(3));
                    root.lName.setText(resultSet.getString(4));
                    root.eMail.setText(resultSet.getString(5));
                    root.phone.setText(resultSet.getInt(6) + "");
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

    private void showResult() {
        try {
            root.id.setText(resultSet.getInt(1) + "");
            root.fName.setText(resultSet.getString(2));
            root.mName.setText(resultSet.getString(3));
            root.lName.setText(resultSet.getString(4));
            root.eMail.setText(resultSet.getString(5));
            root.phone.setText(resultSet.getInt(6) + "");
        } catch (SQLException ex) {
            Logger.getLogger(GuiDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateRow() {
        try {
            resultSet.updateInt(1, Integer.parseInt(root.id.getText()));
            resultSet.updateString(2, root.fName.getText());
            resultSet.updateString(3, root.mName.getText());
            resultSet.updateString(4, root.lName.getText());
            resultSet.updateString(5, root.eMail.getText());
            resultSet.updateInt(6, Integer.parseInt(root.phone.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(GuiDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
