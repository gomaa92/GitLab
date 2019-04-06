package com.mycompany.mavenproject1;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class GuiBase extends AnchorPane {

// islam code
    ResultSet resultSet = null;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final TextField id;
    protected final TextField fName;
    protected final TextField mName;
    protected final TextField lName;
    protected final TextField eMail;
    protected final TextField phone;
    protected final Button newRow;
    protected final Button update;
    protected final Button delete;
    protected final Button first;
    protected final Button previous;
    protected final Button next;
    protected final Button last;

    public GuiBase() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        id = new TextField();
        fName = new TextField();
        mName = new TextField();
        lName = new TextField();
        eMail = new TextField();
        phone = new TextField();
        newRow = new Button();
        update = new Button();
        delete = new Button();
        first = new Button();
        previous = new Button();
        next = new Button();
        last = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(32.0);
        label.setLayoutY(20.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(101.0);
        label.setText("Person Details");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label0.setLayoutX(43.0);
        label0.setLayoutY(69.0);
        label0.setText("ID");

        label1.setLayoutX(44.0);
        label1.setLayoutY(111.0);
        label1.setText("Fisrst Name");

        label2.setLayoutX(44.0);
        label2.setLayoutY(149.0);
        label2.setText("Middel Name");

        label3.setLayoutX(43.0);
        label3.setLayoutY(190.0);
        label3.setText("Last Name");

        label4.setLayoutX(44.0);
        label4.setLayoutY(228.0);
        label4.setPrefHeight(21.0);
        label4.setPrefWidth(43.0);
        label4.setText("Email");

        label5.setLayoutX(44.0);
        label5.setLayoutY(271.0);
        label5.setText("Phone");

        id.setLayoutX(143.0);
        id.setLayoutY(64.0);

        fName.setLayoutX(143.0);
        fName.setLayoutY(106.0);
        fName.setPrefHeight(31.0);
        fName.setPrefWidth(274.0);

        mName.setLayoutX(143.0);
        mName.setLayoutY(144.0);

        lName.setLayoutX(143.0);
        lName.setLayoutY(185.0);
        lName.setPrefHeight(31.0);
        lName.setPrefWidth(274.0);

        eMail.setLayoutX(143.0);
        eMail.setLayoutY(223.0);
        eMail.setPrefHeight(31.0);
        eMail.setPrefWidth(392.0);

        phone.setLayoutX(143.0);
        phone.setLayoutY(266.0);

        newRow.setLayoutX(13.0);
        newRow.setLayoutY(344.0);
        newRow.setMnemonicParsing(false);
        newRow.setPrefHeight(31.0);
        newRow.setPrefWidth(76.0);
        newRow.setText("New..");

        update.setLayoutX(96.0);
        update.setLayoutY(344.0);
        update.setMnemonicParsing(false);
        update.setPrefHeight(31.0);
        update.setPrefWidth(76.0);
        update.setText("Update");

        delete.setLayoutX(179.0);
        delete.setLayoutY(344.0);
        delete.setMnemonicParsing(false);
        delete.setPrefHeight(31.0);
        delete.setPrefWidth(76.0);
        delete.setText("Delete");

        first.setLayoutX(262.0);
        first.setLayoutY(344.0);
        first.setMnemonicParsing(false);
        first.setPrefHeight(31.0);
        first.setPrefWidth(76.0);
        first.setText("First");

        previous.setLayoutX(347.0);
        previous.setLayoutY(344.0);
        previous.setMnemonicParsing(false);
        previous.setText("Previous");

        next.setLayoutX(429.0);
        next.setLayoutY(344.0);
        next.setMnemonicParsing(false);
        next.setPrefHeight(31.0);
        next.setPrefWidth(76.0);
        next.setText("Next");

        last.setLayoutX(510.0);
        last.setLayoutY(344.0);
        last.setMnemonicParsing(false);
        last.setPrefHeight(31.0);
        last.setPrefWidth(76.0);
        last.setText("Last");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(id);
        getChildren().add(fName);
        getChildren().add(mName);
        getChildren().add(lName);
        getChildren().add(eMail);
        getChildren().add(phone);
        getChildren().add(newRow);
        getChildren().add(update);
        getChildren().add(delete);
        getChildren().add(first);
        getChildren().add(previous);
        getChildren().add(next);
        getChildren().add(last);

        // ahmed code
    }
    Statement statement = null;

    ResultSet dataBaseConnection() {
        DataSource dataSource = null;
        dataSource = MyDataSourceFactory.getMySQLDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            try {
                String queryString = "select * from user";
                resultSet = statement.executeQuery(queryString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }


}

