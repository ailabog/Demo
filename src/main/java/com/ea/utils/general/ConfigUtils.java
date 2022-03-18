package com.ea.utils.general;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * All run configurations (e.g urls, credentials, certain filepaths (e.g.
 * secrets)). <br>
 * This is necessary for having complete control over how we treat these.<br>
 * If we have collections of all the endpoints, switching to environments or
 * using mixed infrastructure is done easily. <br>
 * It is also how we handle how we read data when the application is ran in a
 * container.
 * 
 * @author abogasieru@contractor.ea.com
 *
 */
public class ConfigUtils {

	private static Properties prop = new Properties();
	private static InputStream input = null;

	// in case you want to keep track of your keys. there's also a method further
	// down.
	public enum ConfigKeys {
		ENV_DEV_HORIZON, ENV_STAGING_HORIZON, ENV_PROD_HORIZON, ENV_DEV_SUPPORT_SERVICES, ENV_STAGING_SUPPORT_SERVICES,
		ENV_PROD_SUPPORT_SERVICES, ENV_DEV_PARTNERS, ENV_DEV_SSO1, ENV_DEV_OKTA, ENV_DEV_OKTA_ADMIN, ENV_DEV_SSO,
		ENV_PREVIEW_GLU, ENV_PREVIEW_EA, ENV_PREVIEW_EA_ADMIN, ENV_EA_OKTA, ENV_GLU_OKTA, ACCOUNT, PASSWORD,
		BASE_URL_DEVICE, END_URL_DEVICE;
	}

	/**
	 * By default the Tests and the whole application will take its default configs
	 * from: <code>src/test/resources/configs/local-config.properties</code> <br>
	 * This can be altered at Runtime by adding to the maven command: <br>
	 * <code>-DconfigFile=dev</code> if your config file -> <br>
	 * <code>src/test/resources/configs/dev-config.properties</code> <br>
	 * To the method you need to provide one of the keys in the config file. It will
	 * return the value. <br>
	 * If no value will return an empty string. <br>
	 * {@link ConfigUtils}
	 * 
	 * @param propertyKey {@link String}
	 * @return propertyValue {@link String}
	 */
	public static String getProperty(String propertyKey) {
		String result = "";
		String configFile = System.getProperty("configFile") == null ? "local" : System.getProperty("configFile");
		String fullPath = Constants.CONFIG_RESOURCES_PATH + configFile + "-config.properties";

		try {
			input = new FileInputStream(fullPath);
			prop.load(input);
			result = prop.getProperty(propertyKey);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String getProperty(ConfigKeys propertyKey) {
		return getProperty(propertyKey.toString());
	}
}