package com.company;

import com.mysql.cj.jdbc.Driver;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectionToDB
{
    protected static String URL = "jdbc:mysql://localhost:3306/mishkadatabase";
    protected static String LOGIN = "root";
    protected static String PASSWORD = "20205780mZ";



    public void AddToDB(String VALUE1, String VALUE2) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO employee_birthdays (first_name, birthday_date) VALUES ('" + VALUE1 +"','" + VALUE2 + "')");
        connection.close();
    }

    public void DeleteFromDB(String VALUE) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM employee_birthdays WHERE first_name = '" + VALUE + "'");
        connection.close();
    }

    public void EditDB(String VALUE, String FIELD_NAME, String ExpRes) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, SQLException

    {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        //update ??????_?????????????? set ??????_????????=??????????_????????????????_????????, ??????_??????????????_????????=??????????_????????????????_???????? where ??????????????_????_????????????????_????????????????_????????????;
        statement.executeUpdate("UPDATE employee_birthdays SET " + FIELD_NAME + " = '" + VALUE + "' WHERE first_name = '" + ExpRes + "'");

    }
}
