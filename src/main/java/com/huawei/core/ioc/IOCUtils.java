package com.huawei.core.ioc;

/**
 * @author zhangxincheng
 *
 */
public class IOCUtils {

	// #region Fields

	private static IOCUtils m_oInstance;

	// #endregion

	// #region Constructor

	private IOCUtils() {
	}

	/**
	 * getInstance<br>
	 * 
	 * @return m_oInstance
	 */
	public static synchronized IOCUtils getInstance() {
		if (m_oInstance == null) {
			m_oInstance = new IOCUtils();
		}
		return m_oInstance;
	}

	// #endregion

	/**
	 * getBean
	 * 
	 * @param oBeanClass
	 * @return
	 */
	public <T> T getBean(Class<T> oBeanClass) {
		return ServiceAwareHelper.getInstance().getApplicationContext().getBean(oBeanClass);
	}

	public Object getBean(String srtBeanId) {
		return ServiceAwareHelper.getInstance().getApplicationContext().getBean(srtBeanId);
	}
}
