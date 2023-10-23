package api.testing.pojo.responses;

import java.util.Objects;

public class LoginFailedInvalidCredsResponse {
    public String message;
    public Object context;
    public String messageText;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginFailedInvalidCredsResponse that = (LoginFailedInvalidCredsResponse) o;
        return Objects.equals(message, that.message) && Objects.equals(messageText, that.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, context, messageText);
    }
}
