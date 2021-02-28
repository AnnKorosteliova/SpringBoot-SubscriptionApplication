package ann.example.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ann.example.domain.Message;
import ann.example.domain.MessageMapper;
import ann.example.domain.Subscriber;

@Repository
public class MessageRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	SubscriberRepo subscriberRepo;
	
	public String saveMessage(Message message) {
		jdbcTemplate.update("INSERT INTO public.messages("
				+ " content)"
				+ "	VALUES ('" + message.getContent() + "');");
		return "Message is saved!";
	}
	
	public Message getMessageByld(int id) {
		
		Message message = jdbcTemplate.query("SELECT content FROM public.messages"
				+ "	WHERE id=" + id + ";", new MessageMapper()).get(1);
		
		return message;
	}
	
	public List<Message> getMessages(){
		
		List<Message> messages = jdbcTemplate.query("SELECT * FROM public.messages", new MessageMapper());
		return messages;
	}
	
	public Map<Subscriber,Message> getNextUnsendMessage() {
		Map<Subscriber,Message> tuple = new HashMap<>();
		
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT subscriber_id,message_id FROM public.message_subscriber"
				+ "	WHERE sent = false LIMIT 1 OFFSET 0;");
		sqlRowSet.first();
		
		Message message = getMessageByld(sqlRowSet.getInt("message_id"));
		Subscriber subscriber = subscriberRepo.getSubscriberByld(sqlRowSet.getInt("subscriber_id"));
		
		tuple.put(subscriber, message);
		
		return tuple;
	}
}
