package api.testing.pojo.responses;

import java.util.Arrays;
import java.util.Objects;

public class LoginFailedEmptyCredsResponse {
    private String message;
    private Context context;
    private String messageText;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public static class Context {

        public Errors errors;

        public void setErrors(Errors errors) {
            this.errors = errors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Context context = (Context) o;
            return Objects.equals(errors, context.errors);
        }

        @Override
        public String toString() {
            return "Context{" +
                    "errors=" + errors +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(errors);
        }
    }

    public static class Errors {
       public String[] login;

        public void setLogin(String[] login) {
            this.login = login;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Errors errors = (Errors) o;
            return Arrays.equals(login, errors.login);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(login);
        }

        @Override
        public String toString() {
            return "Errors{" +
                    "login=" + Arrays.toString(login) +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginFailedEmptyCredsResponse that = (LoginFailedEmptyCredsResponse) o;
        return Objects.equals(message, that.message)  && Objects.equals(context, that.context)
                && Objects.equals(messageText, that.messageText);
    }

    @Override
    public String toString() {
        return "LoginFailedEmptyCredsResponse{" +
                "message='" + message + '\'' +
                ", context=" + context +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}

