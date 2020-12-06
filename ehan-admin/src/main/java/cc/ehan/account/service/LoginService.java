package cc.ehan.account.service;

import cc.ehan.account.domain.ao.LoginAccountAO;
import cc.ehan.system.service.SysUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:42
 */
@Service
public class LoginService {

    @Autowired
    private SysUserAccountService sysUserAccountService;

    /**
     * 使用账号密码登录
     *
     * @param loginAccountAO
     * @return
     */
    public String loginByAccount(LoginAccountAO loginAccountAO) {
        return null;
    }
}
