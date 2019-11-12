package pl.coderslab.jee.school.model;

import java.util.Objects;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Integer userGroupId;

    public User() {
    }

    public User(String username, String email, String password, Integer userGroupId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String username, String email, String password, Integer userGroupId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userGroupId=" + userGroupId +
                '}';
    }
}
