package ann.example.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageMapper implements RowMapper<Message>{

	@Override
	public Message mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Message message = new Message(resultSet.getString("content"),
									  resultSet.getInt("id"));
		
		return message;
	}

	
	
}
