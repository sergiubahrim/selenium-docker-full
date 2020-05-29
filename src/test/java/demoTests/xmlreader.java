package demoTests;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

public class xmlreader {


  /* public static String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }*/
    String uuid = UUID.randomUUID().toString();
    String tokenR = "nXbKRbQ5sX5n34zTDc5JSjzxfGJ2EE";
    String tokenRsecret = "YypVAtyWHgd@esPm7XDGUcKG3UgXsHvrCVRPuT8d";
    String tokenS = "sqQ3y696@RZuMxzCyXFxudyJcmg8ba";
    String tokenRsecretS = "2vcaZQhkkzUk-vBAFZf9Vrywwe2R4r47u5UVbHgR";
    String URL = "https://api-sandbox.tradeshift.com/tradeshift/rest/external/";
    String xTSidR = "8f961b65-2d56-4de4-8432-b953d4987d3a";
    String xTSidS = "3fd24b17-d14d-4172-b451-257f59d77e6f";

 //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
 //InputStream myRequest = TradeshiftDocumentsAutomation.class.getResourceAsStream("/");
    //File myRequest = new File("/Users/sergiu.bahrim/IdeaProjects/seleniumdockerComplete/src/main/resources/TestData");


 public String readResource(final String fileName, Charset charset) throws IOException {
  return Resources.toString(Resources.getResource(fileName), charset);

 }






}
