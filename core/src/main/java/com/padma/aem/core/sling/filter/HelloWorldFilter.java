package com.padma.aem.core.sling.filter;

import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.osgi.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

import static org.apache.felix.scr.annotations.sling.SlingFilterScope.REQUEST;
import static org.osgi.service.log.LogService.LOG_INFO;


/**
 * Created on 8/11/16.
 */
@SlingFilter(order = 1, scope = REQUEST)
@Property(name = "sling.filter.pattern", value = "")
public class HelloWorldFilter implements Filter
{
	private final Logger logger = LoggerFactory.getLogger(HelloWorldFilter.class);

	@Reference
	private LogService logService;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException
	{
		// do nothing
	}

	@Override
	public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException
	{
		try
		{
			filterChain.doFilter(servletRequest, servletResponse);
		}
		finally
		{
			final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) servletRequest;
			logger.debug("request for {}, with selector {}", slingRequest.getRequestPathInfo().getResourcePath(),
					slingRequest.getRequestPathInfo().getSelectorString());
			logService.log(LOG_INFO, "Handled sling request " + slingRequest.getPathInfo());
		}
	}

	@Override
	public void destroy()
	{
		// do nothing
	}
}
