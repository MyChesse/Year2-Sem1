package module;    //encapsulation

public class Feedback {
    private int id;
    private int studentId; // this is SID
    private String type;
    private String content;
    private boolean reviewed;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isReviewed() {
		return reviewed;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}

    
}
