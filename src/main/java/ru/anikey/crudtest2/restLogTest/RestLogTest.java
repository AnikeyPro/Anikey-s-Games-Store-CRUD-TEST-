package ru.anikey.crudtest2.restLogTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestLogTest {

    private static String url =  "https://public-api.wordpress.com/rest/v1.1/sites/$site/posts/1";

    private static RestTemplate restTemplate =  new RestTemplate();;

    public static void SendRestRequest(){
        try {
            String result = restTemplate.getForObject(url,String.class);
            System.out.println(result);
        }catch (Exception e){
            System.out.println(" ОШИБКА  -  " + e.toString());
        }
    }
}
