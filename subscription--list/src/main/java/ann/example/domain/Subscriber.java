package ann.example.domain;

public class Subscriber {

	private String name;
	private String email;
	private Long id;
	
	public Subscriber(String name, String email, Long id) {
		this.setName(name);
		this.setEmail(email);
		this.setId(id);
	}
	
	public Subscriber(String name, String email) {
		this.setName(name);
		this.setEmail(email);
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Subscriber [name=" + name + ", email=" + email + ", id=" + id + "]";
	}
	
}
