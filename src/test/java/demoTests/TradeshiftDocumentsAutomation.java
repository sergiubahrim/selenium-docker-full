package demoTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class TradeshiftDocumentsAutomation extends xmlreader {


    @Test
    public void getDocumentsBody() {

                Response response = RestAssured
     //GIVEN
                .given()
                    .auth()
                    .oauth("OwnAccount", "OwnAccount", tokenR, tokenRsecret)
                    .header("X-Tradeshift-TenantId", xTSidR)
                    .contentType("application/json")
                    .accept("application/json")
     //WHEN
                .when()
                    .get(URL + "documents?limit=5&withouttag=FETCHED");
     //THEN
                /*.then()
                    .assertThat()
                     .statusCode(201);*/
        System.out.println(response.body().asString());

    }

    @Test
    public void sendInvoice() throws URISyntaxException {
        File myRequest = new File(new URI("file:///Users/sergiu.bahrim/IdeaProjects/seleniumdockerComplete/src/main/resources/TestData.xml"));


        Response response = RestAssured
     //GIVEN
                .given()
                    .auth()
                    .oauth("OwnAccount", "OwnAccount", tokenS, tokenRsecretS)
                    .header("X-Tradeshift-TenantId", xTSidS)
                    .contentType("application/xml; charset=UTF-8")
                    .body(myRequest)
     //WHEN
                .when()
                    .post(URL + "documents/dispatcher?documentId="+uuid+"&documentProfileId=tradeshift.invoice.1.0");
     //THEN
            /*    .then()
                    .assertThat()
                    .statusCode(201);*/
                    System.out.println("Request status code is: " + response.statusCode());
                    System.out.println(response.body().asString());


    }
}
