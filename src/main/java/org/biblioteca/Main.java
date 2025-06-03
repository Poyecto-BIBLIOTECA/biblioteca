package org.biblioteca;

import org.biblioteca.config.DBManager;
import org.biblioteca.view.BookView;

public class Main{
    public static void main (String[]args){
       DBManager.initConnection();
        BookView view = new BookView();
        view.viewMenu();
        DBManager.closeConnection();
    }

}
