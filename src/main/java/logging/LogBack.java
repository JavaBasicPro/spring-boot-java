package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinpanpan on 2018/4/11.
 */
public class LogBack {

    private static final Logger logger = LoggerFactory.getLogger(LogBack.class);

    public static void main(String[] args) {

        logger.debug("logback日志");
    }
}
