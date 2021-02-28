package ann.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import ann.example.controllers.SubscriberController;
import ann.example.domain.Subscriber;
import ann.example.domain.SubscriberMapper;
import ann.example.repositories.SubscriberRepo;
import ann.example.tasks.EmailScheduler;

@ComponentScan
@SpringBootApplication
@EnableScheduling
public class SubscriptionListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionListApplication.class, args);
	}

}
