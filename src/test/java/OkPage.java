import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OkPage {

    public static String login = "TechoBot3";
    public static String password = "TechnoPolis19";
    public static String userName = "WdgPreKWbW UpFAlKUXcu";
    public static PostingPage profilePage;
    public static String postText = "text to post";

    @BeforeAll
    public static void init() {
        open("https://ok.ru");
        login();
        profilePage = new PostingPage(postText);
    }

    @Test
    public static void login() {
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage();
        loginPasswordPage.typeEmail();
        loginPasswordPage.typePassword();
        $(By.xpath(".//input[@value='Log in to OK']")).click();
    }

    @Test
    public void testWriteTopic() {
        profilePage.openPost();
        profilePage.writeAndSubmitPost();
    }

    @Test
    public void testTopic() {
        assertEquals($(By.linkText(userName)).getText(), userName);
        assertEquals($(By.xpath(".//*[@data-link-source='f430']")).getOwnText(), profilePage.getPost());
    }
}