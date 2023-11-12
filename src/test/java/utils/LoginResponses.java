package utils;

import api.testing.pojo.responses.LoginFailedEmptyCredsResponse;
import api.testing.pojo.responses.LoginFailedInvalidCredsResponse;
import domain.constant.Constant;

public class LoginResponses {
    public static LoginFailedInvalidCredsResponse getLoginResponseInvalidCredentials() {
        LoginFailedInvalidCredsResponse expectedLoginResponseInvalidCreds = new LoginFailedInvalidCredsResponse();
        expectedLoginResponseInvalidCreds.message = Constant.LOGIN_AUTHORIZATION_FAILED_SIGN_MESSAGE;
        expectedLoginResponseInvalidCreds.messageText = Constant.LOGIN_FAILED_INVALID_CREDS_MESSAGE;
        return expectedLoginResponseInvalidCreds;
    }
    public static LoginFailedEmptyCredsResponse getLoginResponseEmptyCredentials() {
        LoginFailedEmptyCredsResponse expectedLoginResponseEmptyCreds = new LoginFailedEmptyCredsResponse();
        expectedLoginResponseEmptyCreds.setMessage(Constant.LOGIN_VALIDATION_FAILED_MESSAGE);
        expectedLoginResponseEmptyCreds.setMessageText(Constant.LOGIN_FAILED_EMPTY_FIELDS_REQUEST_ERROR);
        LoginFailedEmptyCredsResponse.Context context = new LoginFailedEmptyCredsResponse.Context();
        LoginFailedEmptyCredsResponse.Errors errors = new LoginFailedEmptyCredsResponse.Errors();
        errors.setLogin(new String[]{Constant.LOGIN_FAILED_EMPTY_FIELDS_ERROR_MESSAGE});
        context.setErrors(errors);
        expectedLoginResponseEmptyCreds.setContext(context);
        return expectedLoginResponseEmptyCreds;
    }
}
