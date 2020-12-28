package cc.ehan.common.exception;

/**
 * 认证异常
 */
public class AuthenticateException extends ExportableException {

    public AuthenticateException(String messageCode) {
        super(messageCode);
    }
}
