import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PostingPage {
    private final String post;
    private final SelenideElement postElem = $(By.xpath(".//div[@data-module='postingForm/mediaText']"));
    private final SelenideElement submitButton = $(By.xpath(".//div[@data-action='submit']"));

    PostingPage(String post) {
        this.post = post;
    }

    public void writeAndSubmitPost() {
        postElem.append(post);
        submitButton.click();
    }

    public void openPost() {
        $(By.xpath(".//*[@class='pf-head_itx_a']")).click();
    }

    public String getPost() {
        return post;
    }
}
