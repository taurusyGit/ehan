package cc.ehan;

import cc.ehan.system.domain.entity.SystemUserEntity;
import cc.ehan.system.mapper.SystemUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

    @Autowired
    private SystemUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void queryTest() {
        QueryWrapper<SystemUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(SystemUserEntity::getGender, "男");
//        PageHelper.startPage(1,20);
        PageHelper.orderBy("id desc");
        List<SystemUserEntity> sysUserEntities =
                sysUserMapper.selectList(queryWrapper);
        sysUserEntities.stream().forEach(System.out::println);
    }

    @Test
    public void testPassword() {
        String password = "zhangzhiyong";
        System.out.println(passwordEncoder.encode(password));
    }
}
