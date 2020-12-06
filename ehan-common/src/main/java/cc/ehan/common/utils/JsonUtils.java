package cc.ehan.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toString(Object o) {
        if (Objects.isNull(o)) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String value, Class<T> c) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return objectMapper.readValue(value, c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
