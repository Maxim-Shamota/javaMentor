package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
//        создание таблицы
        userService.createUsersTable();
//        добавление юзеров
        userService.saveUser("Mary", "Bodrova", (byte) 27);
        userService.saveUser("Nick", "Petrov", (byte) 40);
        userService.saveUser("Helen", "Sidorova", (byte) 32);
        userService.saveUser("Alex", "Ivanov", (byte) 22);
//        вывод в консоль
        for (User s : userService.getAllUsers()) {
            System.out.println(s);
        }
//        очистка таблицы
        userService.cleanUsersTable();
//        удаление таблицы
        userService.dropUsersTable();
    }
}
