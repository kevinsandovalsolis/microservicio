package cl.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
 * 
 * Configuracion de cliente Rest 
 * 
 *@author: kevin sandoval
 */
@Configuration
public class RestClientConfiguration {

	
	//Para llamada de servicios rest (no microservicios)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	

}


