import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTestIssue {

    private static final String baseUrl = "http://github.com";
    private static final String repositoryName = "eroshenkoam/allure-example";
    private static final String issues = "Issues";
    private static final String issueNumber = "#66";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });
        step("Ищем репозиторий " + repositoryName, () -> {
            $(".header-search-input").setValue(repositoryName).submit();
        });
        step("Переходим в репозиторий " + repositoryName, () -> {
            $(By.linkText(repositoryName)).click();
        });
        step("Переходим в раздел " + issues, () -> {
            $(withText(issues)).click();
        });
        step("Проверяем что Issue с номером " + issueNumber + " существует", () -> {
            $(withText(issueNumber)).should(Condition.visible);
        });
    }
}
