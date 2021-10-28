package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        User user1 = new User("Max", "Ivanov", (byte) 31);
        User user2 = new User("Nick", "Petrov", (byte) 25);
        User user3 = new User("Mary", "Bodrova", (byte) 19);
        User user4 = new User("Helen", "Sidorova", (byte) 32);

//        добавление таблицы
        userService.createUsersTable();
//        добавление юзеров
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//        удаление юзера по id
        userService.removeUserById(2);
//        получение всех юзеров
//        userService.getAllUsers();
//        очистка таблицы
//        userService.cleanUsersTable();
//        удаление таблицы
//        userService.dropUsersTable();

    }
}
