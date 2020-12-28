package cc.ehan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author ehan
 * @date 2020/12/9 0009 23:25
 */
public class RedisTest extends BaseTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("1","11111");
    }
}
