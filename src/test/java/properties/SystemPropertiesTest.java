package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.*;

public class SystemPropertiesTest {

    @Test
    @Tag(PROPERTY)
    public void simplePropertiesTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }
}
