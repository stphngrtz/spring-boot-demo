package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public static class DemoController {

		AtomicInteger counter = new AtomicInteger(0);
		String[] messages = new String[] {"/", "/", "/"};

		@RequestMapping(path = "/", method = RequestMethod.GET)
		Map<String, Object> get() {
			return Map.of("counter", counter.get(), "messages", messages);
		}

		@RequestMapping(path = "/", method = RequestMethod.POST)
		void post(@RequestBody String data) {
			counter.incrementAndGet();

			messages[2] = messages[1];
			messages[1] = messages[0];
			messages[0] = data;
		}
	}
}
