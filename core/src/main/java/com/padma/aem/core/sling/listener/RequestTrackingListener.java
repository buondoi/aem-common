package com.padma.aem.core.sling.listener;

import javax.servlet.ServletRequest;
import org.apache.felix.scr.annotations.Component;
import org.apache.sling.api.request.SlingRequestEvent;
import org.apache.sling.api.request.SlingRequestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * It will listen on all requests are handle by SlingMainServlet (i.e including CRXDE etc.)
 * <p>
 * Created on 8/10/16.
 */
@Component
// @Service // disable it currently.
public class RequestTrackingListener implements SlingRequestListener {
    private final Logger logger = LoggerFactory.getLogger(RequestTrackingListener.class);

    @Override
    public void onEvent(final SlingRequestEvent slingRequestEvent) {
        final ServletRequest request = slingRequestEvent.getServletRequest();
        final SlingRequestEvent.EventType type = slingRequestEvent.getType();
        switch (type) {
            case EVENT_INIT: // before request is handled by SlingMainServlet
                logger.info("Started process request " + request.toString());
                break;
            case EVENT_DESTROY: // after service() method of SlingMainServlet.
                logger.info("Ended process request " + request.toString());
                break;
            default:
                break;
        }
    }
}
