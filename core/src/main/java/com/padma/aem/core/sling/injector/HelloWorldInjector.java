package com.padma.aem.core.sling.injector;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.osgi.framework.Constants;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;


/**
 * Inject a "hello world !!!" string.
 * <p>
 * Created on 8/8/16.
 */
@Component
@Service
@Property(name = Constants.SERVICE_RANKING, intValue = 2000)
public class HelloWorldInjector implements Injector
{
	@Override
	public String getName()
	{
		return "helloWorldInjector";
	}

	@Override
	public Object getValue(final Object adaptable, final String name, final Type declaredType,
			final AnnotatedElement annotatedElement, final DisposalCallbackRegistry disposalCallbackRegistry)
	{

		if (declaredType instanceof Class)
		{
			final Class<?> clazz = (Class<?>) declaredType;
			if (clazz.equals(String.class))
			{
				final HelloWorld helloWorld = annotatedElement.getAnnotation(HelloWorld.class);
				if (helloWorld != null)
				{
					return "Hello world - My first injector";
				}
			}
		}
		return null; // return null when no value is resolved.
	}
}
