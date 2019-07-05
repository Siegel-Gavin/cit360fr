package code.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

//This program demonstrates the use of HTTP Url connections. It also demonstrates JSON Objects and how they interact with Java Objects

public class JSON {

    public void main() {
        System.out.println("=================================");
        System.out.println("Http Url Get Request\n");
        getRequest();
        System.out.println("\n================================");
        System.out.println("Http Url Post Request\n");
        postRequest();
    }

    //This demonstrates how to take a json object and convert it to a Java Object using GSON

    private void jsonToObject(StringBuffer response) {
        ArrayList<Post> posts;
        Gson gson = new Gson();
        String jsonStr = response.toString();
        Type listType = new TypeToken<ArrayList<Post>>() {}.getType();
        posts = gson.fromJson(jsonStr, listType);

        for (Post post:
                posts) {
            System.out.println("Title: " + post.title + "\nBody: " + post.body + "\n") ;
        }
    }

     //This demonstrates what to do if we have a bad request

    private void handleBadRequests(Exception e){
        System.out.println(e.getLocalizedMessage());
        System.out.println("Bad Request, try again.");
    }

    //This function takes an object and converts it to a json object using Google's Gson

    private JsonObject objectToJSON() {
        Post post = new Post();
        Gson gson = new Gson();
        post.setBody("Sample and test body");
        post.setTitle("Test Title");
        post.setUserId(1);
        String jsonString = gson.toJson(post);

        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonObject;
    }
    //This sends a post request with Json and displays the response

    private void postRequest() {
        // This part of the code is largely based off of the Mkyong.com tutorial.
        // https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
        String url = "https://jsonplaceholder.typicode.com/posts";

        //I wrap this code in a try catch so that if we get a bad request it doesn't crash the system
        try{
            //Define the url and start the connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            String jsonStr = objectToJSON().toString();
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(jsonStr);
            wr.flush();
            wr.close();

            //add request header
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters: " + jsonStr);
            System.out.println("Response Code : " + responseCode);

            //get the input string
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //convert the response to json.
            System.out.println(response.toString());

        } catch (Exception e){
            handleBadRequests(e);
        }
    }
    // This function sends a get request and then sends the json array to be converted into an array list of objects
    private void getRequest() {
        // This part of the code is largely based off of the Mkyong.com tutorial.
        // https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/

        final String USER_AGENT = "Mozilla/5.0";

        //The location of my request
        String url = "https://jsonplaceholder.typicode.com/posts";

        //I wrap this code in a try catch so that if we get a bad request it doesn't crash the system
        try{
            //Define the url and start the connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            //get the input string
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //convert the response to json.
            jsonToObject(response);
        } catch (Exception e){
            handleBadRequests(e);
        }
    }
}