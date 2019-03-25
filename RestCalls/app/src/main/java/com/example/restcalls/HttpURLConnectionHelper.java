package com.example.restcalls;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionHelper {

    public static String getJsonUsingHttpURLConn() throws Exception{
        String jsonReturnString = "";

        URL url = new URL(ACTUAL_URL);

        httpURLConnection httpURLConnection = null;

        httpURLConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStreamReader = ((HttpURLConnection) httpURLConnection).getInputStream()

        InputStreamReader inputStreamReader = inputStream.read();

        return jsonReturnString;

    }
}
