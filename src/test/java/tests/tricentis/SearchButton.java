package tests.tricentis;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.QueryConverter;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Button `Search`")
@Owner("yuriy")

public class SearchButton extends BaseTest {
    QueryConverter qc = new QueryConverter( );
    private String query;
    private String answer;
    private TestScenario apiTest = new TestScenario( );

    @Test
    @DisplayName("Test 01: Search returns 1 result match.")
    void searchSuccess1Result( ) {
        query = qc.getQuery("query");
        answer = "Show details for Copy of Computing and Internet EX";
        apiTest.searchScenario(query,answer);
    }

    @Test
    @DisplayName("Test 02: Search not found any result matched defined criteria.")
    void searchNoResultTest( ) {
        query = qc.getQuery("query2");
        answer =  "No products were found that matched your criteria.";
        apiTest.searchScenario(query,answer);
    }
}
