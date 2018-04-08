/**
 * @(#)IPValidationRegex.java
 *
 *
 * @author 
 * @version 1.00 2018/4/8
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {    

  private Pattern pattern;

  private Matcher matcher;

  private static final String IPADDRESS_PATTERN =

      "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +

          "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +

          "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +

          "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

  private static final String FILENAME = "IPValidationTestCase.txt";
  private ArrayList<String> ipAddressLs = new ArrayList<String>();
  private String valid = "Valid IP Address";
  private String invalid = "Invalid IP Address";

  public IPValidationRegex() {

    pattern = Pattern.compile(IPADDRESS_PATTERN);

  }

  public boolean validate(final String ipAddress) {

    matcher = pattern.matcher(ipAddress);
    return matcher.matches();

  }

  private void beginValidate() {

    for(int i = 0; i < ipAddressLs.size(); i++) {
      System.out.println(ipAddressLs.get(i) + " :: " + (validate(ipAddressLs.get(i)) == true ? valid : invalid));
    }

  }

  public void getFile() {

    BufferedReader br = null;
    FileReader fr = null;

    try {

      //br = new BufferedReader(new FileReader(FILENAME));
      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);

      String sCurrentLine;

      while((sCurrentLine = br.readLine()) != null) {
        ipAddressLs.add(sCurrentLine);
      }
    } catch(IOException e) {
      e.printStackTrace();
    } finally {

      try {
        if(br != null)
          br.close();
        if(fr != null)
          fr.close();
      } catch(IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws Exception
  {

    IPValidationRegex p = new IPValidationRegex();
    p.getFile();
    p.beginValidate();

  }

}
