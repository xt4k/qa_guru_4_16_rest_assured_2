package tests.tricentis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.QueryConverter;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.HTML;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdvancedSearchForm extends BaseTest {
    QueryConverter qc =new QueryConverter();

    @Test
    @DisplayName("Verify `Search` Button on `Search Form` with successful search.")
    void searchButtonTest (){
        String query=qc.getQuery();

           String body =given()
                .contentType(HTML)
                .params("Q",query)
                .when()
                .get("/search" )
                .then()
                .statusCode(200)
                .extract().response().asString();

        assertThat(body.contains("Show details for Copy of Computing and Internet EX"));

    }

}
