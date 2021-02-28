package ann.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ann.example.domain.Message;
import ann.example.domain.MessageMapper;
import ann.example.domain.Subscriber;
import ann.example.domain.SubscriberMapper;

@Repository
public class SubscriberRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Subscriber> getSubscribers(){
		return jdbcTemplate.query("SELECT * FROM public.subscribers;", new SubscriberMapper());
	}
	
	public List<String> getSubscribersEmailsByIds(List<Integer> ids){
		
		String id_values = "";
//		ids.forEach(id -> id_values += id + ",");
		for (Integer id : ids) {
			id_values += id + ",";
		}
		id_values = id_values.substring(0, id_values.length()-1 );
		
		System.out.println(id_values);
		
		return jdbcTemplate.queryForList("SELECT email FROM public.subscribers WHERE id IN (" + id_values + ");"
				,String.class);
	}
	
	public void save(Subscriber subscriber) {
		jdbcTemplate.update("INSERT INTO public.subscribers("
				+ "	name, email)"
				+ "	VALUES ('" + subscriber.getName() + "', '" + subscriber.getEmail() + "');");
	}
	
	public void updateName(String email, String newName) {
		jdbcTemplate.update("UPDATE public.subscribers"
				+ "	SET name='" + newName + "'"
				+ "	WHERE email='" + email + "';");
	}
	
	public void updateEmail(int id, String newEmail) {
		jdbcTemplate.update("UPDATE public.subscribers"
				+ "	SET email='" + newEmail + "'"
				+ "	WHERE id=" + id + ";");
	}
	
	public void removeById(int id) {
		jdbcTemplate.update("DELETE FROM public.subscribers"
				+ "	WHERE id = " + id + ";");
	}
	
	public Subscriber getSubscriberByld(int id) {
		
		Subscriber subscriber = jdbcTemplate.query("SELECT content FROM public.subscribers"
				+ "	WHERE id=" + id + ";", new SubscriberMapper()).get(0);
		
		return subscriber;
	}
	
}
