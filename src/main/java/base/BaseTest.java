package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.Listeners;
import utilities.CommonFlows;

@Listeners({SuiteListeners.class, TestListeners.class})
public class BaseTest {
    protected final CommonFlows commonFlows = new CommonFlows();
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";
}
