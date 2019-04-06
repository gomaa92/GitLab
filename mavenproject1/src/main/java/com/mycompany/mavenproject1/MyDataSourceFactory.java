/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import javax.activation.DataSource;
import javax.sql.DataSource;

/**
 *
 * @author Gom3a
 */
public class MyDataSourceFactory {
    // gom3a start here

    public static DataSource getMySQLDataSource() {
        Properties properties = new Properties();
        FileInputStream fileInput = null;
        MysqlDataSource mysqlDataSource = null;
        try {
            fileInput = new FileInputStream("db.properties");
            properties.load(fileInput);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty("URL"));
            mysqlDataSource.setUser(properties.getProperty("userName"));
            mysqlDataSource.setPassword(properties.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return mysqlDataSource;

    }

}
