package main.logic;

import backend.Database;

import java.sql.SQLException;
import main.ui.SignIn;

public class Main {
    public static void main(String[] args) throws SQLException {

        Database db = Database.getInstance();



        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignIn(db).setVisible(true);
                try{
                    addAdminAccount(db);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });








    }
    public static void addAdminAccount(Database db) throws SQLException {

        if(!db.validateUserLogIn(db.getUser(), db.getPass())){
            db.insertDataToTable(db.getUser(), db.getPass());
        }
        else{
            System.out.println("Admin is added already!");
        }
    }
}
