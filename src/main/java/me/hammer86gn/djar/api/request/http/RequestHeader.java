package me.hammer86gn.djar.api.request.http;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class RequestHeader {
    private final Header header;
    private final String key;
    private final String value;

    public RequestHeader(String key, String value) {
        this.key = key;
        this.value = value;
        header = new BasicHeader(key,value );
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Header toApacheHeader() {
        return header;
    }
}
