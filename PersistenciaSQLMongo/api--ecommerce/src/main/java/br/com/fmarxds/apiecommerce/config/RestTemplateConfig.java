package br.com.fmarxds.apiecommerce.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory, Logbook logbook) {
        RestTemplate restTemplate = new RestTemplate(bufferingClientHttpRequestFactory);
        restTemplate.getInterceptors().add(new LogbookClientHttpRequestInterceptor(logbook));
        return restTemplate;
    }

    @Bean
    public BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory() {
        return new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    }

}
