package com.chandraMohan.taskManager.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Development");

        Server prodServer = new Server()
                .url("http://ec2-13-201-20-236.ap-south-1.compute.amazonaws.com:8080")
                .description("AWS EC2 Production");

        return new OpenAPI()
            .info(
                    new Info()
                        .title("Task Manager APIs")
                        .description("By Chandra Mohan")
            )
            .servers(Arrays.asList(localServer, prodServer));
    }
}
