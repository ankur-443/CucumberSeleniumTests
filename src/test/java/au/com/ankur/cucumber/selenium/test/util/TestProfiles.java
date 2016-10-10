package au.com.ankur.cucumber.selenium.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton Profile reader
 *
 */
public class TestProfiles {
	
	private String urlKey = "url";
	private String osKey = "os";
	private String browserKey = "browser";
	private String deviceNameKey = "deviceName";
	private String isDeviceTestingEnabledKey = "enableMobileDevice";
	private String path = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator +
			"profiles";
	
	private static TestProfiles reader = null;
	
	private TestProfiles() throws IOException {
		String profileName = System.getProperty(TestConstants.PROFILE);
		 String filePath = path + File.separator + profileName + ".properties";
		 Properties properties = new Properties();
		 InputStream stream = null;
		 try {
			 stream = new FileInputStream(new File(filePath));
			 properties.load(stream);
			 assign(properties);
		} finally {
			if(stream != null){
				stream.close();
			}
		}
	}
	
	public static TestProfiles getInstance() throws IOException {
		if(reader == null){
			reader = new TestProfiles();
		}
		return reader;
	}
	
	private void assign(Properties properties) {
		setUrl(System.getProperty("url", (String) properties.get(urlKey)));
		setBrowser(System.getProperty("browser", (String) properties.get(browserKey)));
		setDeviceName(System.getProperty("deviceName", (String) properties.get(deviceNameKey)));
		setEnableDeviceTesting(System.getProperty("enableMobileDevice", (String) properties.get(isDeviceTestingEnabledKey)));
	}

	public String getUrl() {
		return urlKey;
	}
	public void setUrl(String url) {
		this.urlKey = url;
	}
	public String getOs() {
		return osKey;
	}
	public void setOs(String os) {
		this.osKey = os;
	}
	public String getBrowser() {
		return browserKey;
	}
	public void setBrowser(String browser) {
		this.browserKey = browser;
	}
	public String getDeviceName() {
		return deviceNameKey;
	}
	public void setDeviceName(String device) {
		this.deviceNameKey = device;
	}
	
	public void setEnableDeviceTesting(String property) {
		this.isDeviceTestingEnabledKey = property;
	}

	public boolean getEnableDeviceTesting() {
		return Boolean.valueOf(this.isDeviceTestingEnabledKey);
	}
}
