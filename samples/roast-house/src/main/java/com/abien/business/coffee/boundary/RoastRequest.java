package com.abien.business.coffee.boundary;

import com.abien.business.coffee.entity.Bean;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author adam-bien.com
 */
public class RoastRequest {

    private Bean bean;
    private AsyncResponse ar;

    public RoastRequest(Bean bean, AsyncResponse ar) {
        this.bean = bean;
        this.ar = ar;
    }

    public Bean getBean() {
        return bean;
    }

    public void sendMessage(String result) {
        Response response = Response.ok(result).build();
        ar.resume(response);
    }

    public void errorHappened(Exception ex) {
        ar.resume(ex);
    }
}
