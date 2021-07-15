package POJO;

public class PostsAPIPojo {
	
	private String title;
	private String body;
	private String userId;
	
	public PostsAPIPojo(String title, String body, String userId) {
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
