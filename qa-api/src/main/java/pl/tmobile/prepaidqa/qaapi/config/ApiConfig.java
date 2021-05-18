package pl.tmobile.prepaidqa.qaapi.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ApiConfig {

    private static final Config CONFIG = ConfigFactory.load("api-config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String BASE_URL = ENV.getString("baseURL");
    public static final String BASE_MOCK_URL = ENV.getString("baseURLMock");
    public static final String BASE_MOCK_PATH = ENV.getString("basePathMock");
    public static final String BASE_AZURE_URL = ENV.getString("baseAzureURL");
    public static final String BASE_AZURE_PATH = ENV.getString("baseAzurePath");

}
