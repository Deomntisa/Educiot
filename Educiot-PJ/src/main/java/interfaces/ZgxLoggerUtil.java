package interfaces;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ZgxLoggerUtil {
    private static Logger log = Logger.getLogger(ZgxLoggerUtil.class);

    public static Logger getLogger(Class clazz) {
        // 封装这个的主要原因是为了读取log4j.properties配置文件 不然每次都要写一次
        PropertyConfigurator.configure(String.format("%s\\src\\log4j.properties", System.getProperty("user.dir")));
        Logger log = Logger.getLogger(clazz);
        return log;
    }
}
