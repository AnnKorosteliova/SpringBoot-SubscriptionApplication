package ann.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ann.example.domain.Message;
import ann.example.domain.MessageMapper;

public class MessageRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String saveMessage(Message message) {
		jdbcTemplate.update("INSERT INTO public.messages("
				+ " content)"
				+ "	VALUES ('" + message.getContent() + "');");
		return "Message is saved!";
	}
	
	public void getMessageByld(int id) {
		jdbcTemplate.update("SELECT FROM public.messages"
				+ "	WHERE id=" + id + ";");
	}
	
	public void getMessages(){
		jdbcTemplate.query("SELECT * FROM public.messages", new MessageMapper());
	}
}
