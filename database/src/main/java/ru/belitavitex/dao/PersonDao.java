package ru.belitavitex.dao;

import ru.belitavitex.connection.ConnectionManager;
import ru.belitavitex.entity.Groups;
import ru.belitavitex.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzianis on 09.04.2017.
 */
public class PersonDao {
    private static final Object LOCK = new Object();
    private static PersonDao INSTANCE = null;

    public static PersonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonDao();
                }
            }
        }
        return INSTANCE;
    }

    public static List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    " SELECT p.id, first_name, lastName, email, password, address, " +
                            "phone, groups_name FROM person AS p JOIN groups AS g ON " +
                            "p.groups_id = g.id")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        list.add(new Person(resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("lastName"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("address"),
                                resultSet.getString("phone"),
                                Groups.valueOf(resultSet.getString("groups_name"))));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}


