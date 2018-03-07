package com.neo;

import com.neo.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 参考纯洁微笑
 * http://www.cnblogs.com/ityouknow/p/6944096.html
 */

@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceZuulApplication.class, args);
	}

	@Bean
	public TokenFilter tokenFilter(){
		return new TokenFilter();
	}
}
