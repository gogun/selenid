import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPasswordPage {
    private final SelenideElement login = $(By.name("st.email"));
    private final SelenideElement pass = $(By.name("st.password"));

    public LoginPasswordPage() {
    }

    public void typeEmail() {
        login.append(OkPage.login);
    }

    public void typePassword() {
        pass.append(OkPage.password);
    }
}
