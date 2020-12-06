package cc.ehan;

import cc.ehan.system.domain.entity.SysUserEntity;
import cc.ehan.system.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void queryTest() {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(SysUserEntity::getGender,"男");
//        PageHelper.startPage(1,20);
        PageHelper.orderBy("id desc");
        List<SysUserEntity> sysUserEntities =
                sysUserMapper.selectList(queryWrapper);
        sysUserEntities.stream().forEach(System.out::println);
    }
}
