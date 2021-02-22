package ann.example.domain;

public class Message {

	private String content;
	private int id;
	
	public Message(String content, int id) {
		setContent(content);
		setId(id);
	}
	
	public Message(String content) {
		setContent(content);
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message [content=" + content + ", id=" + id + "]";
	}
	
}
