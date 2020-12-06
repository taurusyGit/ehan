package cc.ehan.security.userdetails;

import cc.ehan.common.utils.message.MessageCode;
import cc.ehan.common.utils.message.MessageUtils;
import cc.ehan.system.constants.SysUserStateEnum;
import cc.ehan.system.domain.bo.SysUserAccountLoginBO;
import cc.ehan.system.service.SysUserAccountService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author ehan
 * @date 2020/12/2 0002 1:34
 */
@Component
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserAccountService sysUserAccountService;

    /**
     * 账户的登录密码过期时间，单位 天。默认为30天
     */
    private Integer accountPasswordExpiredTime = 30;

    public Integer getAccountPasswordExpiredTime() {
        return accountPasswordExpiredTime;
    }

    public void setAccountPasswordExpiredTime(Integer accountPasswordExpiredTime) {
        this.accountPasswordExpiredTime = accountPasswordExpiredTime;
    }

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        SysUserAccountLoginBO loginAccount = sysUserAccountService.selectLoginAccountByAccountName(accountName);
        if (Objects.isNull(loginAccount)) {
            throw new UsernameNotFoundException(MessageUtils.getMessage(MessageCode.ACCOUNT_NOT_FIND));
        }
        return createUserDetails(loginAccount);
    }

    private UserDetails createUserDetails(SysUserAccountLoginBO loginAccount) {
        //账户名
        String username = loginAccount.getAccountName();
        // 账户密码
        String password = StrUtil.emptyIfNull(loginAccount.getAccountPassword());
        // 账户是否启可用
        boolean enabled = Objects.equals(SysUserStateEnum.ENABLED.getValue(), loginAccount.getState());
        // 账户是否不过期
        boolean accountNonExpired = true;

        //  密码是否不过期
        boolean credentialsNonExpired;
        Date accountPasswordUpdateTime = loginAccount.getAccountPasswordUpdateTime();
        if (Objects.isNull(accountPasswordUpdateTime)) {
            credentialsNonExpired = false;
        } else if (Objects.isNull(accountPasswordExpiredTime)) {
            credentialsNonExpired = true;
        } else {
            credentialsNonExpired = DateUtil.offsetDay(accountPasswordUpdateTime, accountPasswordExpiredTime).after(DateUtil.date());
        }


        // 账号是否未被锁定
        boolean accountNonLocked = true;

        return new LoginUserDetail(loginAccount.getId(), username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked);
    }
}
