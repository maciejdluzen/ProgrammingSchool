package pl.coderslab.jee.school.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Solution {

    private Integer id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String description;
    private Integer exerciseId;
    private Exercise exercise;
    private Integer userId;
    private User user;

    public Solution() {
    }

    public Solution(LocalDateTime created, String description, Integer exerciseId, Integer userId) {
        this.created = created;
        this.description = description;
        this.exerciseId = exerciseId;
        this.userId = userId;
    }

    public Solution(Integer id, LocalDateTime created, String description, Integer exerciseId, Integer userId) {
        this.id = id;
        this.created = created;
        this.description = description;
        this.exerciseId = exerciseId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(id, solution.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", description='" + description + '\'' +
                ", exerciseId=" + exerciseId +
                ", userId=" + userId +
                '}';
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
