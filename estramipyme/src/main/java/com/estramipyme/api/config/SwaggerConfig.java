package com.estramipyme.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/**")
				.addOpenApiCustomiser(openApiCustomiser())
				.build();
	}
	
	private OpenApiCustomiser openApiCustomiser() {
		return openApi -> openApi.info(new Info()
				.title("Test swagger")
				.version("1.0.0")
				.description("Api test para java"));
	}
	
}
