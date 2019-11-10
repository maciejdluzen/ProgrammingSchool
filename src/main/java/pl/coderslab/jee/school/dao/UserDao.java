package pl.coderslab.jee.school.dao;

import pl.coderslab.jee.school.db.DbUtil;
import pl.coderslab.jee.school.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    private static final String CREATE = "INSERT INTO users (username, email, password, user_group_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET username = ?, email = ?, password = ?, user_group_id = ? WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM users";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_ALL_BY_GROUP_ID = "SELECT * FROM users WHERE user_group_id = ?";

    public static void save(User modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modelObj.getUsername());
            statement.setString(2, modelObj.getEmail());
            statement.setString(3, modelObj.getPassword());
            statement.setInt(4, modelObj.getUserGroupId());
            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Błąd dodania wpisu: " + modelObj);
            }

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.first()) {
                    modelObj.setId(resultSet.getInt(1));
                }
                else {
                    throw new RuntimeException("Błąd uzyskania klucza głównego dla: " + modelObj);
                }
            }
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static void update(User modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, modelObj.getUsername());
            statement.setString(2, modelObj.getEmail());
            statement.setString(3, modelObj.getPassword());
            statement.setInt(4, modelObj.getUserGroupId());
            statement.setInt(5, modelObj.getId());

            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Błąd zaktualizowania wpisu: " + modelObj);
            }
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<User> findAll() {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            List<User> results = new LinkedList<>();
            while (resultSet.next()) {
                User object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static User findById(Integer id) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return convertFrom(resultSet);
            }

            return null;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<User> findAllByGroupId(Integer groupId) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_GROUP_ID)) {
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();

            List<User> results = new LinkedList<>();
            while (resultSet.next()) {
                User object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    private static User convertFrom(ResultSet resultSet) throws SQLException {
        User object = new User();
        object.setId(resultSet.getInt("id"));
        object.setUsername(resultSet.getString("username"));
        object.setEmail(resultSet.getString("email"));
        object.setPassword(resultSet.getString("password"));
        object.setUserGroupId(resultSet.getInt("user_group_id"));
        return object;
    }
}
