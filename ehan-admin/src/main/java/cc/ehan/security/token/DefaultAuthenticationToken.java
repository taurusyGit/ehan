package cc.ehan.security.token;

import cc.ehan.security.DefaultLoginAccount;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author ehan
 * @date 2020/11/30 0030 22:10
 */
public class DefaultAuthenticationToken extends AbstractAuthenticationToken {

    private DefaultLoginAccount defaultLoginAccount;

    public DefaultAuthenticationToken(DefaultLoginAccount defaultLoginAccount) {
        super(null);
        this.defaultLoginAccount = defaultLoginAccount;
    }

    @Override
    public Object getCredentials() {
        return defaultLoginAccount.getAccountPassword();
    }

    @Override
    public Object getPrincipal() {
        return defaultLoginAccount.getAccountName();
    }
}
