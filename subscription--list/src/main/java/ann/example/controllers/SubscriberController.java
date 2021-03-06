package ann.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ann.example.domain.Subscriber;
import ann.example.repositories.SubscriberRepo;

@RestController
public class SubscriberController {

	@Autowired
	SubscriberRepo subscriberRepo;
	
	@GetMapping("/subscribers")
	public List<Subscriber> subscriberIndex(){
		
		return subscriberRepo.getSubscribers();
	}
	
	@PostMapping("/subscribers/add")
	public String subscriberAdd(@RequestParam(required=true) String email, @RequestParam(required=true) String name){
		
		subscriberRepo.save(new Subscriber(name, email));
		
		return "Subscriber added!";
	}
	
	@GetMapping("/subscribers/setname/{email}/{newName}")
	public String subscriberSetName(@PathVariable String email, @PathVariable String newName){
		
		subscriberRepo.updateName(email, newName);
		
		return "Subscriber updated!";
	}

}
