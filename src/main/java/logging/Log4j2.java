package logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by jinpanpan on 2018/4/11.
 */
public class Log4j2 {

    private static final Logger logger = LogManager.getLogger(Log4j2.class);

    public static void main(String[] args) {

            logger.debug("jdk自带的日志需要引入log4j2的jar包 和 log4j2.xml 的配置文件");
    }
}
