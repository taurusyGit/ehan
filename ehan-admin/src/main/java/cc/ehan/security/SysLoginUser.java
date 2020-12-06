package cc.ehan.security;

import lombok.Data;

import java.util.Set;

/**
 * @author ehan
 * @date 2020/12/2 0002 0:31
 */
@Data
public class SysLoginUser extends AbstractLoginUser {


    @Override
    public Set<String> getPermission() {
        return null;
    }

    @Override
    public Set<String> getRoles() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }
}
