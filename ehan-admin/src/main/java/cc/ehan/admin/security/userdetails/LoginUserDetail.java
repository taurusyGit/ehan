package cc.ehan.admin.security.userdetails;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class LoginUserDetail extends User {

    private final Long userId;

    public LoginUserDetail(Long userId, String username, String password, boolean enabled,
                           boolean accountNonExpired, boolean credentialsNonExpired,
                           boolean accountNonLocked) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, Collections.emptyList());
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
