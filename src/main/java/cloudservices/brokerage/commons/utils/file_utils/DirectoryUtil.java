/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.commons.utils.file_utils;

import java.io.File;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class DirectoryUtil {

    public static boolean creatDir(String path) {
        File theDir = new File(path);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
                return true;
            } catch (SecurityException se) {
                return false;
            }
        } else {
            return true;
        }
    }
}
