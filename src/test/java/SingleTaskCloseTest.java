import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class SingleTaskCloseTest extends TestBase{

    @Test
    public void RandomSingleTaskClose(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToTfs("jamrok");
    }
}
