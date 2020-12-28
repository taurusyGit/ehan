package cc.ehan.system.mapper;

import cc.ehan.system.domain.bo.SystemUserAccountLoginBO;
import cc.ehan.system.domain.entity.SystemUserAccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:38
 */
public interface SystemUserAccountMapper extends BaseMapper<SystemUserAccountEntity> {


    SystemUserAccountLoginBO selectLoginAccountByAccountName(String accountName);
}
