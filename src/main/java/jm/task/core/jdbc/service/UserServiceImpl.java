package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        Util util = new Util();

        try (Statement statement = util.getConnection().createStatement()) {

            statement.execute("CREATE TABLE `users`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));");

        } catch (SQLException e) {
        }
    }

    public void dropUsersTable() {
        Util util = new Util();

        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("drop table users");
        } catch (SQLException e) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();

        try (PreparedStatement statement = util.getConnection().prepareStatement
                ("insert into users (name, lastName, age) values(?,?,?)")) {

//            statement.executeUpdate("insert into users (name, lastName, age) values(?,?,?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.execute();
            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException e) {

        }
    }

    public void removeUserById(long id) {
        Util util = new Util();

        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("delete from users where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        Util util = new Util();
        List<User> list = new ArrayList<>();
        try (Statement statement = util.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users")) {
            String name;
            String lastName;
            byte age;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                lastName = resultSet.getString("lastName");
                age = resultSet.getByte("age");

                User user = new User(name, lastName, age);
                list.add(user);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void cleanUsersTable() {
        Util util = new Util();

        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("delete from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
