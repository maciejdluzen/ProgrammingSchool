package pl.coderslab.jee.school.dao;

import pl.coderslab.jee.school.db.DbUtil;
import pl.coderslab.jee.school.model.Exercise;
import pl.coderslab.jee.school.model.Solution;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SolutionDao {

    private static final String CREATE = "INSERT INTO solutions (description, created, user_id, exercise_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE solutions SET description = ?, updated = ? WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM solutions";
    private static final String FIND_ALL_WITH_LIMIT = "SELECT * FROM solutions ORDER BY created LIMIT ?";
    private static final String FIND_ALL_BY_USER_ID = "SELECT * FROM solutions WHERE user_id = ?";
    private static final String FIND_ALL_BY_EXERCISE_ID = "SELECT * FROM solutions WHERE exercise_id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM solutions WHERE id = ?";
    private static final String FIND_DESCRIPTION = "SELECT description FROM solutions WHERE id = ?";

    public static Solution loadById(Integer id) {
        try (Connection conn = DbUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(FIND_DESCRIPTION)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                return convertFrom(resultSet);
            }

            return null;

        } catch (SQLException sqlExc) {
            throw new RuntimeException("Bład w zapisie");
        }
    }

    public static void save(Solution modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modelObj.getDescription());
            statement.setTimestamp(2, Timestamp.valueOf(modelObj.getCreated()));
            statement.setInt(3, modelObj.getUserId());
            statement.setInt(4, modelObj.getExerciseId());
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

    public static void update(Solution modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, modelObj.getDescription());
            statement.setTimestamp(2, Timestamp.valueOf(modelObj.getUpdated()));
            statement.setInt(3, modelObj.getId());

            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Błąd zaktualizowania wpisu: " + modelObj);
            }
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<Solution> findAll() {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            List<Solution> results = new LinkedList<>();
            while (resultSet.next()) {
                Solution object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<Solution> findAll(int limit) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_WITH_LIMIT)) {
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();

            List<Solution> results = new LinkedList<>();
            while (resultSet.next()) {
                Solution object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<Solution> findAllByUserId(Integer userId) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_USER_ID)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            List<Solution> results = new LinkedList<>();
            while (resultSet.next()) {
                Solution object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<Solution> findAllByExerciseId(Integer exerciseId) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_EXERCISE_ID)) {
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();

            List<Solution> results = new LinkedList<>();
            while (resultSet.next()) {
                Solution object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static Solution findById(Integer id) {
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

    private static Solution convertFrom(ResultSet resultSet) throws SQLException {
        Solution object = new Solution();
        object.setId(resultSet.getInt("id"));
        if (resultSet.getTimestamp("created") != null) {
            object.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        }
        if (resultSet.getTimestamp("updated") != null) {
            object.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
        }
        object.setDescription(resultSet.getString("description"));
        object.setUserId(resultSet.getInt("user_id"));
        object.setExerciseId(resultSet.getInt("exercise_id"));
        return object;
    }
}
