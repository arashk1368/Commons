/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.commons.utils.file_utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class FileChecker {

    public static boolean compare(InputStream is1, InputStream is2) throws IOException {
        return IOUtils.contentEquals(is1, is2);
    }
}
