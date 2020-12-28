package cc.ehan.system.constants;

/**
 * 系统用户状态
 * @author ehan
 * @date 2020/12/4 0004 21:07
 */
public enum SystemUserStateEnum {

    /**
     * 有效状态 10
     */
    ENABLED("10"),

    /**
     * 禁用状态 11
     */
    DISABLED("11");

    private String value;

    SystemUserStateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
