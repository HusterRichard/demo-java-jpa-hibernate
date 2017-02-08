package com.huawei.core.ioc;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 潛規則：使用時需要配合使用ImportResource和ComponentScan(basePackages="xxx.xxx.xxx")<br>
 * 方便獲取Spring各種服務對象的Helper類<br>
 * 
 * @author zhangxincheng
 *
 */
@Component
public class ServiceAwareHelper
		implements ApplicationContextAware, ResourceLoaderAware, MessageSourceAware, InitializingBean {

	// #region Fields

	private static ServiceAwareHelper serviceAwareHelper;

	private ApplicationContext applicationContext;

	private ResourceLoader resourceLoader;

	private MessageSource messageSource;

	public static ServiceAwareHelper getInstance() {
		return serviceAwareHelper;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	// #endregion

	// #region afterPropertiesSet

	/*
	 * Bean初始化之後回掉此方法，在此時檢查裝配的情況<br>
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		serviceAwareHelper = this;
		if (applicationContext == null) {
			throw new BeanInstantiationException(getClass(), "applicationContext is null");
		}

		if (resourceLoader == null) {
			throw new BeanInstantiationException(getClass(), "resourceLoader is null");
		}

		if (messageSource == null) {
			throw new BeanInstantiationException(getClass(), "messageSource is null");
		}
	}

	// #endregion

	// #region Setter of override

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	// #endregion

}
