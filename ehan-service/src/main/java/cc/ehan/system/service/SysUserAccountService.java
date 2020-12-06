package cc.ehan.system.service;

import cc.ehan.system.domain.bo.SysUserAccountLoginBO;
import cc.ehan.system.mapper.SysUserAccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:40
 */
@Service
public class SysUserAccountService {

    @Resource
    private SysUserAccountMapper sysUserAccountMapper;

    public SysUserAccountLoginBO selectLoginAccountByAccountName(String accountName) {
        return sysUserAccountMapper.selectLoginAccountByAccountName(accountName);
    }

    ;
}
