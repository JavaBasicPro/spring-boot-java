package logging;


import java.util.logging.Logger;

/**
 * Created by jinpanpan on 2018/4/10.
 *
 * jdk自带的logging介绍
 */
public class JDKLogging {

    private static final Logger logger=Logger.getLogger(JDKLogging.class.getName());

    public static void main(String [] args){

        logger.info("jdk自带的日志需要引入import java.util.logging.Logger" );

    }

}
