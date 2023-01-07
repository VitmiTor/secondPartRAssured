package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.Listeners;
import utilities.Logs;

import java.io.File;

@Listeners({SuiteListeners.class, TestListeners.class})
public class BaseTest {
    protected Logs logs = new Logs();
    private final String schemaFolder = "src/test/resources/schemas";

    protected final String smoke = "Smoke";
    protected final String regression = "Regression";

    protected File getSchema(String json) {
        final var path = String.format("%s/%s", schemaFolder, json);
        return new File(path);
    }
}
