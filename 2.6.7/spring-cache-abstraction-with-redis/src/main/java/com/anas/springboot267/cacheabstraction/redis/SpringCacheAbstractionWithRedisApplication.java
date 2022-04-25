package com.anas.springboot267.cacheabstraction.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheAbstractionWithRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheAbstractionWithRedisApplication.class, args);
	}

}
