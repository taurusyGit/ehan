package cc.ehan.security.filter;

import cc.ehan.common.utils.JsonUtils;
import cc.ehan.security.DefaultLoginAccount;
import cc.ehan.security.token.DefaultAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @author ehan
 */
public class DefaultAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final DefaultLoginAccount EMPTY_ACCOUNT = new DefaultLoginAccount("", "");

    protected DefaultAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        DefaultLoginAccount usernamePassword = getUsernamePassword(request);
        DefaultAuthenticationToken authenticationToken = new DefaultAuthenticationToken(usernamePassword);
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }

    private DefaultLoginAccount getUsernamePassword(HttpServletRequest request) throws IOException {
        String requestValue = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        DefaultLoginAccount account = JsonUtils.toObject(requestValue, DefaultLoginAccount.class);
        return Objects.isNull(account) ? EMPTY_ACCOUNT : account;
    }
}
