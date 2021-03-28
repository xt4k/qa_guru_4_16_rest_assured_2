package tests.tricentis;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.filters;
import static java.lang.System.setProperty;

public class BaseTest {

    @BeforeEach
    @DisplayName("Precondition step")
    void setUp( ) {
        baseURI = "http://demowebshop.tricentis.com";
        filters(new AllureRestAssured( ));
        Properties properties = new Properties( );
        try {
            properties.load(new FileReader("src/test/resources/common.properties"));
        } catch (IOException e) {
            e.printStackTrace( );
        }
        properties.forEach((key, value) -> setProperty((String) key, (String) value));
    }

}
