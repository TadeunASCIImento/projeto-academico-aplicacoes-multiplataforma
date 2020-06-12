package br.com.appbuscapessoa.servicos;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceControllerHTTP extends AsyncTask < String, Void, String > implements URLConstantsHTTP {

    @Override
    public String doInBackground(String...string) {
        String url = (String) string[0];
        String xml = (String) string[1];

        try {
            HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();
            try {
                request.setDoOutput(true);
                request.setDoInput(true);
                request.setRequestProperty("Content-Type", "application/xml");
                request.setRequestMethod("POST");
                request.connect();
                try (OutputStream outputStream = request.getOutputStream()) {
                    outputStream.write(xml.getBytes("UTF-8"));
                }

                return readResponse(request);
            } finally {
                request.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "Cp1252"))) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = br.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }



}