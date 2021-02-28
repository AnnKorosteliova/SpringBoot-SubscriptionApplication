package ann.example.tasks;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ann.example.domain.Message;
import ann.example.domain.Subscriber;
import ann.example.repositories.MessageRepo;

@Component
public class EmailScheduler {

	@Autowired
	MessageRepo messageRepo;
	
	@Scheduled(fixedRate = 20000, initialDelay = 0)
	public void sendEmail() {
		System.err.println("PREPARING TO SEND EMAIL");
		Map<Subscriber,Message> tuple = messageRepo.getNextUnsendMessage();
		System.err.println(tuple);
	}
	
}
