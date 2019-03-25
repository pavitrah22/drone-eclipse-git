package commonLib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;
	private final String propFilePath = "src//test//resource//configs//config.properties";
	
	public ConfigFileReader() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at "+ propFilePath);
		}
	}
	
	public String getURL() {
		String url = properties.getProperty("url");
		if(url != null) {
			return url;
	}else {
		throw new RuntimeException("Config.properties not found in Config properties file");
	}
 }
	
}
