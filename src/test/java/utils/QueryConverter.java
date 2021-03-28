package utils;

import io.qameta.allure.Step;

import static java.lang.System.getProperty;

public class QueryConverter {

    @Step("Convert query from file in API request form.")
    public String getQuery( ) {
        String[] parts = getProperty("query").split(" ");
        StringBuilder finalQuery = new StringBuilder( );
        for (String part : parts)
            if (part.length( ) > 0) finalQuery.append("+").append(part);
        return finalQuery.toString( );
    }
}