package ann.example.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubscriberMapper implements RowMapper<Subscriber>{

	@Override
	public Subscriber mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Subscriber subscriber = new Subscriber(
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getLong("id")
				);
		
		return subscriber;
	}

	
	
}
