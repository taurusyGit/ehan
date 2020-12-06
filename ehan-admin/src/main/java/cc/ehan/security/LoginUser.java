package cc.ehan.security;

import java.util.Set;

/**
 * @author ehan
 * @date 2020/12/1 0001 23:09
 */
public interface LoginUser {

    Set<String> getPermission();

    Set<String> getRoles();

    Long getId();

    void setToken(String token);

    String getToken();

    Boolean getSuperAdmin();
}
