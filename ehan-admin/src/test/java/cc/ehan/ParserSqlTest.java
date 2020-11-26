package cc.ehan;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.Test;

public class ParserSqlTest {

    @Test
    public void test1() throws Exception {
        String sql = "select a,b,c,d from sys_user where a = ? or b = ? and c in (select id from a) order by a";
        Statement parse = CCJSqlParserUtil.parse(sql);
        System.out.println(parse);
        Select select = (Select) parse;
        SelectBody selectBody = select.getSelectBody();
        System.out.println(selectBody);

        String scope = "and (select dept_id from sys_dept where id = 1)";
        parse = CCJSqlParserUtil.parse(scope);
        System.out.println(parse);
    }
}
