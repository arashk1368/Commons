/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.commons.utils.url_utils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class URLExtracter {

    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
}
