/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.commons.utils.file_utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class DirectoryUtil {

    public static boolean createDir(String path) {
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
    
    public static List<File> getAllFiles(String directoryName){
        List<File> files=new ArrayList<File>();
        listf(directoryName, files);
        return files;
    }
    
    private static void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
}
