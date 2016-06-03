package com.padma.aem.core.use;

import com.adobe.cq.sightly.WCMUse;


/**
 * Created on 6/3/16.
 */
public class HelloWorldUse extends WCMUse
{
	private String message;

	@Override
	public void activate() throws Exception
	{
		this.message = "\tHello World!\n";
	}

	public String getMessage()
	{
		return message;
	}

	public String getText()
	{
		return getProperties().get("text", String.class);
	}
}
