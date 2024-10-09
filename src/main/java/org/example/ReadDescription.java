package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDescription {
    public static void main(String[] inpt) {
        String url = "jdbc:sqlserver://localhost:1234;database=ваша_база;encrypt=true;trustServerCertificate=true;";
        String username = "ваш_логин";
        String password = "ваш_пароль";

        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String predZapros = "SELECT * FROM Books WHERE ID_book = ?";
            try (PreparedStatement zapros = connect.prepareStatement(predZapros)) {
                zapros.setInt(1, Integer.parseInt(inpt[0]));
                try (ResultSet rs = zapros.executeQuery()) {
                    if (rs.next()) {
                        String title = rs.getString("Title");
                        String author = rs.getString("Author");
                        int year = rs.getInt("Year");
                        System.out.println("Сведения о книге:");
                        System.out.println("Название: " + title);
                        System.out.println("Автор: " + author);
                        System.out.println("Год издания: " + year);
                    } else {
                        System.out.println("Книга не найдена");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}
