package logging;

import org.apache.log4j.Logger;

/**
 * Created by jinpanpan on 2018/4/11.
 */
public class Log4j {

    private static final Logger logger= Logger.getLogger(Log4j.class);

    public static void main(String [] args){

            logger.debug("jdk自带的日志需要引入log4j的jar包");

    }
}
