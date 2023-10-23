package api.testing.pojo.requests;

import java.util.Objects;
public class LoginRequest {
    public String login;
    public String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
