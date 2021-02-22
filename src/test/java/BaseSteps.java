import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Step("Открываем главную страницу")
    public static void openGitHub(){
        open("http://github.com");
    }

    @Step("Ищем репоизторий")
    public static void searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий")
    public static void goToRepositoryFromSearch(String repository){
        $(By.linkText(repository)).click();
    }
    @Step("Переходим в раздел Issues")
    public static void openRepositoryIssues(){
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue с тайтлом #66 существует")
    public static void shouldSeeIssueWithNumber(String issueNumber){
        $(withText(issueNumber)).should(Condition.visible);
    }
}
