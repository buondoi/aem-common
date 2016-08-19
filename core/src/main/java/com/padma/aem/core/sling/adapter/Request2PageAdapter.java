package com.padma.aem.core.sling.adapter;

import com.day.cq.wcm.api.Page;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.adapter.AdapterFactory;


/**
 * Adapt a {@link org.apache.sling.api.SlingHttpServletRequest} to {@link com.day.cq.wcm.api.Page}.
 * Created on 8/18/16.
 */
@Component
@Service
public class Request2PageAdapter implements AdapterFactory
{
	@Property(name = "adapters")
	public static final String[] ADAPTER_CLASSES = { Page.class.getName() };

	@Property(name = "adaptables")
	public static final String[] ADAPTABLE_CLASSES = { SlingHttpServletRequest.class.getName() };

	@Override
	public <AdapterType> AdapterType getAdapter(final Object adaptable, final Class<AdapterType> type)
	{
		if (adaptable instanceof SlingHttpServletRequest && Page.class.isAssignableFrom(type))
		{
			// TODO convert request to page.
		}
		return null;
	}
}
