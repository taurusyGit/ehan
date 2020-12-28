package cc.ehan.admin.modules.authentication.service;

import cc.ehan.admin.modules.authentication.domain.ao.LoginAccountAO;
import cc.ehan.admin.security.LoginUser;
import cc.ehan.admin.security.SecurityManager;
import cc.ehan.common.exception.AuthenticateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@Slf4j
public class AdminAuthenticationService {

    @Autowired
    private SecurityManager securityManager;

    public String loginByAccount(LoginAccountAO loginAccountAO) {
        Object principal = loginAccountAO.getAccountName();
        Object credentials = loginAccountAO.getAccountPassword();
        Collection authorities = Collections.emptyList();
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        String token = null;
        try {
            token = securityManager.loginVerify(authentication);
        } catch (AuthenticationException e) {
            throw new AuthenticateException();
        }
        if (log.isDebugEnabled()) {
            log.debug("账号 {} 登录成功，token为：{}", principal, token);
        }
        return token;
    }

    /**
     * 根据token获取对应的会话用户信息
     *
     * @return
     */
    public LoginUser getOwnerLoginUser() {
        LoginUser loginUser = securityManager.getLoginUser();
        return loginUser;
    }
}
