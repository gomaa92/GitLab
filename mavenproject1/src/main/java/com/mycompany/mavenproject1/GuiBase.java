/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Gom3a
 */
public class GuiBase {
    
    ResultSet resultSet = null;
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
