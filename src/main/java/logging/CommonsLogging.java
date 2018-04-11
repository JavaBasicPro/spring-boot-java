package logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by jinpanpan on 2018/4/11.
 */
public class CommonsLogging {

    private static final Log logger= LogFactory.getLog(CommonsLogging.class);

    public static void main(String [] args){

        logger.info("commons-logging的日志配置" );

    }
}
