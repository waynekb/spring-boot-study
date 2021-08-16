package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
@EnableScheduling //确保后台任务执行被创建
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		log.info("main start");
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * 访问其他服务获取数据 RestServer
	 * */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Resource
	RestTemplate restTemplate;
	@GetMapping("/hello")
	public String hello() {
		Quote quote = restTemplate.getForObject(
				"https://quoters.apps.pcfone.io/api/random", Quote.class);
		return quote.toString();
	}

	@Bean
	public CommandLineRunner run(ApplicationContext ctx) throws Exception {
		return args -> {
			log.info("Let's inspect the beans provided by spring boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				//log.info(beanName);
			}
		};
	}
}


@RestController
class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/**
	 * 绑定url路径 @RequestParam 修饰参数，绑定url中的name参数和函数参数mingzi
	 * */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String mingzi) {
		return new Greeting(counter.incrementAndGet(), String.format(template,mingzi));
	}
}

