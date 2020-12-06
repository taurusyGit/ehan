package cc.ehan.system.mapper;

import cc.ehan.system.domain.bo.SysUserAccountLoginBO;
import cc.ehan.system.domain.entity.SysUserAccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:38
 */
public interface SysUserAccountMapper extends BaseMapper<SysUserAccountEntity> {


    SysUserAccountLoginBO selectLoginAccountByAccountName(String accountName);
}
