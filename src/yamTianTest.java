import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class yamTianTest {
    private final static String USER_AGENT = "Mozilla/5.0";
    private static int imageCount = 0;
    
    public static void main (String[] args) {   
        Scanner scanner = new Scanner(System.in);
        String account;
        String albumId;
        String urlFetch;
        String allImages = "";
        int page = 1;
        boolean isFinalPage = false;
        
        System.out.println("account:");
        account = scanner.nextLine();
        System.out.println("albumId:");
        albumId = scanner.nextLine();
        System.out.println(account + " " +albumId);
        scanner.close();
        
        String filePath = System.getProperty ("user.home") + "/Documents/"+"testTian/" + "test.txt";
//        File myFile = new File (filePath);
//        System.out.println("myFile length: " + myFile.length());
        
        // test
//        account = "love7824";
//        albumId = "5676138";
        
        // test 2018
        urlFetch = "https://" + account + ".tian.yam.com/ajax/album/fetch";
        //urlFetch = "https://" + account + ".tian.yam.com/ajax/notify/get";
        
        String result = "";
        
        do {
            try {
                result = sendPost(urlFetch, albumId, Integer.toString(page));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            // test 2018
            System.out.println(result);
            
            JSONObject object = new JSONObject(result);
            
            if (object.getInt("code") != 200) {
                System.out.println("Error! code: " + object.getInt("code"));
                return;
            }
            
            JSONArray photoArray = object.getJSONArray("photos");
            
            for (int i = 0; i < photoArray.length(); i++) {
                String image = photoArray.getJSONObject(i).getString("url");
                System.out.println(image);
                allImages += (image + "\n");
                imageCount++;
            }
            isFinalPage = object.getBoolean("lastPage");
            //System.out.println("page:" + object.getInt("page") + " finalPage? " + isFinalPage);
            page++;
        } while (!isFinalPage);
        
        System.out.println("page:" + page + " finalPage? " + isFinalPage);
        System.out.println("image count: " + imageCount);
        
        // write file
        try{
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            writer.print(allImages);
            writer.close();
        } catch (IOException e) {
           // do something
            System.out.println("IOException while writing file");
        }
        
    }
    
    
    // HTTP POST request
    private static String sendPost(String url, String albumId, String page) throws Exception {

        StringBuilder tokenUri=new StringBuilder("page=");
        tokenUri.append(URLEncoder.encode(page,"UTF-8"));
        tokenUri.append("&albumId=");
        tokenUri.append(URLEncoder.encode(albumId,"UTF-8"));
//        tokenUri.append("&param3=");
//        tokenUri.append(URLEncoder.encode("param3","UTF-8"));
//        url += ("page=" + page);
//        url += ("&albumId=" + albumId);
 
        //String url = "https://example.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "UTF-8");
 
        con.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
        outputStreamWriter.write(tokenUri.toString());
        outputStreamWriter.flush();
 
        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + tokenUri);
//        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        
        //System.out.println(response.toString());
        return response.toString();

    }
        
//        //URL url = new URL("http://yoururl.com");
//        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//        conn.setReadTimeout(10000);
//        conn.setConnectTimeout(15000);
//        conn.setRequestMethod("POST");
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("firstParam", paramValue1));
//        params.add(new BasicNameValuePair("secondParam", paramValue2));
//        params.add(new BasicNameValuePair("thirdParam", paramValue3));
//
//        OutputStream os = conn.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(os, "UTF-8"));
//        writer.write(getQuery(params));
//        writer.flush();
//        writer.close();
//        os.close();
//
//        conn.connect();
        
        
//        //String url = "https://selfsolve.apple.com/wcResults.do";
//        URL obj = new URL(url);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add reuqest header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());

    
}
