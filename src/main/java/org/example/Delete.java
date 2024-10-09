package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] inpt) {
        String url = "jdbc:sqlserver://localhost:1234;database=ваша_база;encrypt=true;trustServerCertificate=true;";
        String username = "ваш_логин";
        String password = "ваш_пароль";

        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String predZapros = "DELETE FROM Books WHERE ID_book = ?";
            try (PreparedStatement zapros = connect.prepareStatement(predZapros)) {
                zapros.setInt(1, Integer.parseInt(inpt[0]));
                int rowsAffected = zapros.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Книга удалена!");
                } else {
                    System.out.println("Такой книги нет!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}
