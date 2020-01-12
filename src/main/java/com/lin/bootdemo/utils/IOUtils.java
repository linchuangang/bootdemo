package com.lin.bootdemo.utils;


import com.lin.bootdemo.exception.ApsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author gd
 * @Date 2019/9/3 14:33
 * @Description resource op
 */
public class IOUtils {
    private static final Logger logger= LoggerFactory.getLogger(IOUtils.class);

    /**
     *  close resources
     * @param closeables
     */
    public static void closeResources(Closeable ... closeables)
    {
        for (Closeable closeable:closeables)
        {
            if (closeable!=null)
            {
                try
                {
                    closeable.close();
                }
                catch (IOException e)
                {
                    logger.error("close resource failure",e);
                }
                catch (Throwable t)
                {
                    t.addSuppressed(new ApsException("can not resolve this io exception,close resource failure!"));
                }
            }
        }
    }
}
