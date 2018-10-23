package ru.egor.connection;

import ru.egor.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {

    public User getUserByLogin(String login) throws SQLException {
        User result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM 'user' " +
                "WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = new User(resultSet.getString("login"),
                    resultSet.getString("password"));
        }
        connection.close();
        return result;
    }

    public void addUser(User user) throws SQLException {
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user\" (login, password) values (?, ?)");
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.execute();

            connection.close();

    }
}
