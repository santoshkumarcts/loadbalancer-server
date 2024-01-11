package com.example.loadbalancer.server.loadbalancerserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Value("${server.instance.id}")
	String instanceId;

	@GetMapping("/test")
	public String hello(@RequestParam(value = "reqParam",required = true) String reqParam,@RequestParam(value = "param") String param)
	{
		return String.format("Hello from instance %s and reqParam %s and param %s", instanceId,reqParam);
	}
}
