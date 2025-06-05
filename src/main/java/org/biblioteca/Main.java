package org.biblioteca;

import org.biblioteca.config.DBManager;
import org.biblioteca.view.BookView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main (String[]args) throws SQLException {
        BookView view = new BookView();
        view.viewMenu();
        DBManager.closeConnection();
    }
}
