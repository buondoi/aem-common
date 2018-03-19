package com.padma.aem.core.sling.adapter;

import com.day.cq.wcm.api.Page;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import static org.apache.felix.scr.annotations.sling.SlingFilterScope.REQUEST;
import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created on 8/18/16.
 */
@SlingFilter(name = "Common AEM Page filter", order = 100, scope = REQUEST, metatype = true)
@Property(name = "sling.filter.pattern", value = "")
public class Request2PageAdapterFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(Request2PageAdapterFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // do nothing.
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
        throws IOException, ServletException {
        try {
            final SlingHttpServletRequest request = (SlingHttpServletRequest) servletRequest;
            final Page page = request.adaptTo(Page.class);
            if (page != null) {
                logger.info("The request can be adapted to ");
            }
        } finally {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        // do nothing.
    }
}
