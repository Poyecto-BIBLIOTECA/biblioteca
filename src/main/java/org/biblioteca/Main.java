package org.biblioteca;

import org.biblioteca.config.DBManager;

public class Main{
    public static void main (String[]args){
        DBManager.initConnection();
    }
}
