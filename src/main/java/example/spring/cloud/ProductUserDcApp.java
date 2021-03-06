package example.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ProductUserDcApp {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "dc-product-user");
		SpringApplication.run(ProductUserDcApp.class, args);
	}
	
	/*@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}*/
	
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

}
