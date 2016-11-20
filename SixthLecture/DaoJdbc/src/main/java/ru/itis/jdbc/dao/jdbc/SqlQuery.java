package ru.itis.jdbc.dao.jdbc;


public class SqlQuery {

    // language=SQL
    static final String SQL_SELECT_USER = "SELECT * FROM users_table WHERE id = ?;";
    // language=SQL
    static final String SQL_SELECT_USER_BY_CITY = "SELECT * FROM users_table WHERE city = ?;";
    // language=SQL
    static final String SQL_INSERT_USER = "INSERT INTO users_table(name, age, city)" +
            " VALUES(?, ?, ?);";
    // language=SQL
    static final String SQL_UPDATE_USER = "UPDATE users_table SET name = ?, age = ?, city = ?" +
            " WHERE id = ?";
    // language=SQL
    static final String SQL_DELETE_USER = "DELETE FROM users_table WHERE id=?";
    // language=SQL
    static final String SELECT_ALL_USER = "SELECT * FROM users_table";
    // language=SQL
    static final String SELECT_COUNT_USER = "SELECT COUNT(name) AS count FROM users_table WHERE name = ?;";

    // language=SQL
    static final String SQL_SELECT_CAR = "SELECT * FROM cars WHERE id = ?;";
    // language=SQL
    static final String SQL_INSERT_CARS = "INSERT INTO cars(car_model, car_mileage, user_id)" +
            " VALUES(?, ?, ?);";
    // language=SQL
    static final String SQL_UPDATE_CARS = "UPDATE cars SET id= ?,car_model = ?, car_mileage = ?" +
            " WHERE id = ?;";
    // language=SQL
    static final String SQL_DELETE_CARS = "DELETE FROM cars WHERE id=?;";
    // language=SQL
    static final String SELECT_ALL_USERS_CARS = "SELECT * FROM cars WHERE user_id=?";
    // language=SQL
    static final String SELECT_ALL_CARS = "SELECT * FROM cars";
    // language=SQL
    static final String SELECT_CARS_BY_CITY = "SELECT c.* FROM cars c RIGHT JOIN users_table u ON c.user_id = u.id WHERE u.city = ?;";
}
