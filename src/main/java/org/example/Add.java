package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {
    public static void main(String[] inpt) {
        String url = "jdbc:sqlserver://localhost:1234;database=ваша_база;encrypt=true;trustServerCertificate=true;";
        String username = "ваш_логин";
        String password = "ваш_пароль";

        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String predZapros = "INSERT INTO Books (Title, Author, Year) VALUES (?, ?, ?)";
            try (PreparedStatement zapros = connect.prepareStatement(predZapros)) {
                zapros.setString(1, inpt[0]);
                zapros.setString(2, inpt[1]);
                zapros.setInt(3, Integer.parseInt(inpt[2]));
                zapros.executeUpdate();
                System.out.println("Книга добавлена!");
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}
