package ann.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ann.example.domain.Subscriber;
import ann.example.repositories.SubscriberRepo;

//functionality:
//	same as SubscriberController
//	SECURE!!!
//	+ remove subscriber
//	+ send mass message 
//	+ change email

@Controller
public class AdminController {

	@Autowired
	SubscriberRepo subscriberRepo;
	
	@GetMapping("admin/subscribers")
	public String adminSubscriberIndex(Model model){
		
		model.addAttribute( "subscribers", subscriberRepo.getSubscribers() );
		return "admin/subscribers";
	}
	
	@GetMapping("admin/subscribers/compose")
	public String adminSubscriberCompose(@RequestParam() List<Integer> subscribers){
		
		System.out.println(subscribers);
		List<String> emails = subscriberRepo.getSubscribersEmailsByIds(subscribers);
		System.out.println(emails);
		return "admin/compose";
	}
	
	@PostMapping("/admin/subscribers/remove")
	public String adminSubscriberRemove(@RequestParam(required=true) int id){
		
		subscriberRepo.removeById(id);

		return "Subscriber " + id + " removed!";
	}
	
	@PostMapping("/admin/subscribers/send")
	public String adminSubscribersSendMessage(@RequestParam(required=true) String message){
		
		return message;
	}
	
	@PostMapping("/admin/subscribers/setemail")
	public String adminSubscribersSetEmail(@RequestParam(required=true) int id, @RequestParam(required=true) String newEmail){
		
		subscriberRepo.updateEmail(id, newEmail);
		
		return "Subscriber updated!";
	}
	
	
	
	

}
