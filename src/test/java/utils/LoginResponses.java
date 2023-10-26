package utils;

import api.testing.pojo.responses.LoginFailedEmptyCredsResponse;
import api.testing.pojo.responses.LoginFailedInvalidCredsResponse;

public class LoginResponses {
    public static LoginFailedInvalidCredsResponse getLoginResponceInvalidCredentials() {
        LoginFailedInvalidCredsResponse expectedLoginResponseInvalidCreds = new LoginFailedInvalidCredsResponse();
        expectedLoginResponseInvalidCreds.message = "exception.auth.invalid_sign_in";
        expectedLoginResponseInvalidCreds.messageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        return expectedLoginResponseInvalidCreds;
    }
    public static LoginFailedEmptyCredsResponse getLoginResponceEmptyCredentional() {
        LoginFailedEmptyCredsResponse expectedLoginResponseEmptyCreds = new LoginFailedEmptyCredsResponse();
        expectedLoginResponseEmptyCreds.setMessage("exception.validation.failed");
        expectedLoginResponseEmptyCreds.setMessageText("Запрос не соответствует правилам валидации");
        LoginFailedEmptyCredsResponse.Context context = new LoginFailedEmptyCredsResponse.Context();
        LoginFailedEmptyCredsResponse.Errors errors = new LoginFailedEmptyCredsResponse.Errors();
        errors.setLogin(new String[]{"Заполните оба поля"});
        context.setErrors(errors);
        expectedLoginResponseEmptyCreds.setContext(context);
        return expectedLoginResponseEmptyCreds;
    }
}
