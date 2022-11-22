package ru.anikey.crudtest2.restLogTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class RestLogTest {

    @PostConstruct
    private void init() {
        sendRestRequest();
    }

    private final String URL = "https://public-api.wordpress.com/rest/v1.1/sites/$site/posts/1";

    private final RestTemplate restTemplate;

    public RestLogTest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendRestRequest() {
        try {
            String result = restTemplate.getForObject(URL, String.class);
            log.info("result = {}", result);
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}
