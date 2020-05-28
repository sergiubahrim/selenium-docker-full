package demoTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

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
    public void sendInvoice() {

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
