package cc.ehan.common.utils;

import cc.ehan.common.exception.SystemException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;

/**
 * @author ehan
 * @date 2020/12/6 0006 23:39
 */
public class BeanCopyUtils extends BeanUtils {

    public static <T> T copyPropertiesByClass(Object source, Class<T> target) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        T result = null;
        try {
            result = target.newInstance();
        } catch (Exception e) {
            throw new SystemException(e);
        }
        copyProperties(source, result);
        return result;
    }
}
