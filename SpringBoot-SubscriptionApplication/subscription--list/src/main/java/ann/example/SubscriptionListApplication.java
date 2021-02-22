package ann.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ann.example.controllers.SubscriberController;
import ann.example.domain.Subscriber;
import ann.example.domain.SubscriberMapper;
import ann.example.repositories.SubscriberRepo;

@ComponentScan(basePackageClasses = {SubscriberRepo.class, Subscriber.class, SubscriberController.class, SubscriberMapper.class})
@SpringBootApplication
public class SubscriptionListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionListApplication.class, args);
	}

}
