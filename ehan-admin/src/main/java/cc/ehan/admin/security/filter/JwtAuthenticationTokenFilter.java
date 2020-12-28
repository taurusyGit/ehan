package cc.ehan.admin.security.filter;

import cc.ehan.admin.security.LoginUser;
import cc.ehan.admin.security.SecurityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * token过滤器 验证token有效性
 *
 * @author ruoyi
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private SecurityManager securityManager;

    public JwtAuthenticationTokenFilter(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        LoginUser loginUser = securityManager.getLoginUser();
        if (Objects.nonNull(loginUser)) {
            securityManager.refreshToken(loginUser);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, Collections.emptyList());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
