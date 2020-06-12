package br.com.appbuscapessoa.testes;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServiceTestePOST {



    public String sendPOST(String url, String xml) throws MinhaException {
        try {
            HttpURLConnection request = (HttpURLConnection) new URL (url).openConnection();
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
            throw new MinhaException(ex);
        }
    }


    private String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        try (BufferedReader br = new BufferedReader(new InputStreamReader (request.getInputStream(), "UTF-8"))) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = br.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }

    public static class MinhaException extends Exception {
        public MinhaException(Throwable cause) {
            super(cause);
        }
    }

}
