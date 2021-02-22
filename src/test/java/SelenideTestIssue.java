import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestIssue {

    private static final String baseUrl = "http://github.com";
    private static final String repositoryName = "eroshenkoam/allure-example";
    private static final String issues = "Issues";
    private static final String issueNumber = "#66";

    @Test
    @Owner("polyakovan")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base URL", value = baseUrl)

    @Feature("Issues")
    @Story("Поск Issue")
    @DisplayName("Поиск Issue по номеру в репозитории")
    public void testIssueSearch() {
        open(baseUrl);
        $(".header-search-input").setValue(repositoryName).submit();
        $(By.linkText(repositoryName)).click();
        $(withText(issues)).click();
        $(withText(issueNumber)).should(Condition.exist);
    }
}
