package com.gmail.shulgin220618;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class TextChecker {
    private static String url = "https://speller.yandex.net/services/spellservice/checkText";

    public static String checkText(String text) throws IOException {
        String result = "";
        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("text",text));
        post.setEntity(new UrlEncodedFormEntity(urlParameters,  "UTF-8"));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){
            result = EntityUtils.toString(response.getEntity());
        }
        return result;
    }

}
