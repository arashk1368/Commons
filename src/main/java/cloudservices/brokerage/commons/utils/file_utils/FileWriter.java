/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.commons.utils.file_utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class FileWriter {

    public static void writeInputStream(InputStream inputStream, File file) throws IOException {
        OutputStream outputStream = null;

        try {
            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    public static void writeInputStream(InputStream inputStream, File file, String starting) throws IOException {
        OutputStream outputStream = null;

        try {
            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(file);

            outputStream.write(starting.getBytes());
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    public static void appendString(String toWrite, String path) throws IOException {
        Files.write(Paths.get(path), toWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }
}
