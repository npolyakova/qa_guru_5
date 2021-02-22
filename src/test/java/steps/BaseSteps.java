package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Step("Открываем главную страницу")
    public void openGitHub(){
        open("http://github.com");
    }

    @Step("Ищем репоизторий")
    public void searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий")
    public void goToRepositoryFromSearch(String repository){
        $(By.linkText(repository)).click();
    }
    @Step("Переходим в раздел Issues")
    public void openRepositoryIssues(){
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue с тайтлом {issueNumber} существует")
    public void shouldSeeIssueWithNumber(String issueNumber){
        $(withText(issueNumber)).should(Condition.visible);
    }
}
