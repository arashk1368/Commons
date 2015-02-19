/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.commons.utils.url_utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class URLRequester {

    private final static Logger LOGGER = Logger.getLogger(URLRequester.class
            .getName());

    public static InputStream getInputStreamFromURL(String uri, String userAgent) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //add request header
        connection.setRequestProperty("User-Agent", userAgent);

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return connection.getInputStream();
        } else {
            LOGGER.log(Level.INFO, "URL : {0} Returned ERROR Response : {1}", new Object[]{url, responseCode});
            throw new Exception("URL : {0} Returned ERROR Response : " + responseCode);
        }
    }
}
