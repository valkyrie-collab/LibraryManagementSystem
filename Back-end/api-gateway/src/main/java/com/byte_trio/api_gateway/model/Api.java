package com.byte_trio.api_gateway.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class Api {
    private RouterFunction<ServerResponse> get(String name, String finalRoute, String initialRoute) {
        return route(name).GET(finalRoute, http()).before(uri(initialRoute)).build();
    }

    private RouterFunction<ServerResponse> post(String name, String finalRoute, String initialRoute) {
        return route(name).POST(finalRoute, http()).before(uri(initialRoute)).build();
    }

    private RouterFunction<ServerResponse> delete(String name, String finalRoute, String initialRoute) {
        return route(name).DELETE(finalRoute, http()).before(uri(initialRoute)).build();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return post("authentication", "/user/**", "http://localhost:8085/")
                .and(
                        post("book-post", "/book/**", "http://localhost:8084/")
                ).and(
                        get("book-get", "/book/**", "http://localhost:8084/")
                ).and(
                        delete("book-delete", "/book/**", "http://localhost:8084/")
                ).and(
                        post("entity-post", "/entity/**", "http://localhost:8083/")
                ).and(
                        get("entity-get", "/entity/**", "http://localhost:8083/")
                ).and(
                        delete("entity-delete", "/entity/**", "http://localhost:8083/")
                ).and(
                        post("fine-post", "/fine/**", "http://localhost:8082/")
                ).and(
                        get("fine-get", "/fine/**", "http://localhost:8082/")
                ).and(
                        delete("fine-delete", "/fine/**", "http://localhost:8082/")
                ).and(
                        post("trans-post", "/transaction/**", "http://localhost:8081")
                ).and(
                        get("trans-get", "/transaction/**", "http://localhost:8081")
                ).and(
                        get("trans-delete", "/transaction/**", "http://localhost:8081")
                );
    }
}
