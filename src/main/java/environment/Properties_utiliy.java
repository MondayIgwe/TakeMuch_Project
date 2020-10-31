package environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Properties_utiliy {

    static Properties properties;

    public static void main(String[] args) throws IOException {
       getProperties();
    }

    public static void getProperties() throws IOException {
        properties = new Properties();
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        properties.load(fi);
        System.out.println(fi.available());
    }
}
