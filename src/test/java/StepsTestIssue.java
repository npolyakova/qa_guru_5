import org.junit.jupiter.api.Test;

public class StepsTestIssue extends BaseSteps{

    private static final String repository = "eroshenkoam/allure-example";
    private static final String issueNumber = "#68";

    @Test
    public void testIssueSearch() {
        openGitHub();
        searchForRepository(repository);
        goToRepositoryFromSearch(repository);
        openRepositoryIssues();
        shouldSeeIssueWithNumber(issueNumber);
    }
}
