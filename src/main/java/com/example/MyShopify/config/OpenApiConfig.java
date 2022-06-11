package com.example.MyShopify.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Online Shopify Store",
                description = "Operations pertaining to products in Online Store",
                contact = @Contact(
                        name = "",
                        url = "",
                        email = ""
                ),
                license = @License(
                        name = "",
                        url = "")),
        servers = @Server(url = "http://localhost:8083")
)
public class OpenApiConfig {
}
