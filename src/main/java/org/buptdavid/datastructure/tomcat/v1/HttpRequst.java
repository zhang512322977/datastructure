package org.buptdavid.datastructure.tomcat.v1;

import java.util.HashMap;
import java.util.Map;

public class HttpRequst {

    public HttpRequst(String reqBody) {
        this.reqBody = reqBody;
    }

    public HttpRequst() {
    }

    private Map<String,String> headers = new HashMap<>();

    private String reqBody;

    private String protocol;

    private String version;

    private String requrl;

    public String getRequrl() {
        return requrl;
    }

    public void setRequrl(String requrl) {
        this.requrl = requrl;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getReqBody() {
        return reqBody;
    }

    public void setReqBody(String reqBody) {
        this.reqBody = reqBody;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
