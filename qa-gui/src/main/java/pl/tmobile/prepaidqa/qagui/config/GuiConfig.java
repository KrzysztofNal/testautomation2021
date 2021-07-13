package pl.tmobile.prepaidqa.qagui.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class GuiConfig {

    private static final Config CONFIG = ConfigFactory.load("gui-config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String BROWSER = CONFIG.getString("browser");

    public static final String BASE_WORDPRESS_URL = ENV.getString("baseWordpressUrl");
    public static final String BASE_DIARY_URL = ENV.getString("diaryBasePage");
    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");

}
