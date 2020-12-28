package cc.ehan.system.service;

import cc.ehan.system.domain.bo.SystemUserAccountLoginBO;
import cc.ehan.system.mapper.SystemUserAccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:40
 */
@Service
public class SystemUserAccountService {

    @Resource
    private SystemUserAccountMapper sysUserAccountMapper;

    public SystemUserAccountLoginBO selectLoginAccountByAccountName(String accountName) {
        return sysUserAccountMapper.selectLoginAccountByAccountName(accountName);
    }
}
