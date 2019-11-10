package pl.coderslab.jee.school.dao;

import pl.coderslab.jee.school.db.DbUtil;
import pl.coderslab.jee.school.model.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExerciseDao {

    private static final String CREATE = "INSERT INTO exercises (title, description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE exercises SET title = ?, description = ? WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM exercises";
    private static final String FIND_BY_ID = "SELECT * FROM exercises WHERE id = ?";

    public static void save(Exercise modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modelObj.getTitle());
            statement.setString(2, modelObj.getDescription());
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

    public static void update(Exercise modelObj) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, modelObj.getTitle());
            statement.setString(2, modelObj.getDescription());
            statement.setInt(3, modelObj.getId());

            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Błąd zaktualizowania wpisu: " + modelObj);
            }
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static List<Exercise> findAll() {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            List<Exercise> results = new LinkedList<>();
            while (resultSet.next()) {
                Exercise object = convertFrom(resultSet);
                results.add(object);
            }

            return results;
        } catch (SQLException sqlExc) {
            throw new RuntimeException("Błąd zapisu", sqlExc);
        }
    }

    public static Exercise findById(Integer id) {
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

    private static Exercise convertFrom(ResultSet resultSet) throws SQLException {
        Exercise object = new Exercise();
        object.setId(resultSet.getInt("id"));
        object.setTitle(resultSet.getString("title"));
        object.setDescription(resultSet.getString("description"));
        return object;
    }
}
