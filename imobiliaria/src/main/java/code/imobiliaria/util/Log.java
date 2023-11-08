/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Log{
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("MyApplication.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.FINE);
            LOGGER.setUseParentHandlers(false); // Do not print to console
        } catch (IOException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }

    public static void main(String[] args) {
        setupLogger();
        LOGGER.info("Logging an INFO-level message");
        try {
            // Your application logic here
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred", e);
        }
    }

    public static void error1(String an_error_occurred, SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void error2(String an_error_occurred, SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void error3(String an_error_occurred, SQLException sqlException) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void error4(String an_error_occurred, SQLException sqlException) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
