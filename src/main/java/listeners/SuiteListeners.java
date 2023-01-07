package listeners;

import data.Credentials;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListeners implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Credentials.generateToken();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }
}
