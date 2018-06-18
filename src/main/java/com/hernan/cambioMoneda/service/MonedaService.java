package com.hernan.cambioMoneda.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MonedaService {

	public String consumirServicio() {
		String output="";
        try { 
 
            URL url = new URL("http://data.fixer.io/api/latest?access_key=bb482363016b99283d49e26daa9e6a56");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            } 
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            output=br.readLine();
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            } 
            conn.disconnect();
 
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        } 
        return output;
    } 
	

}
