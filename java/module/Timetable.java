package module;

public class Timetable {

	private int id;

	public Timetable(int id, String subject, String day, String startTime, String endTime) {
	    this.id = id;
	    this.subject = subject;
	    this.day = day;
	    this.startTime = startTime;
	    this.endTime = endTime;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

private String subject;
private String day;
private String startTime;
private String endTime;

public Timetable(String subject, String day, String startTime, String endTime) {
    this.subject = subject;
    this.day = day;
    this.startTime = startTime;
    this.endTime = endTime;
}//encapsulation:

public String getSubject() {
    return subject;
}

public String getDay() {
    return day;
}

public String getStartTime() {
    return startTime;
}

public String getEndTime() {
    return endTime;
}

public void setSubject(String subject) {
    this.subject = subject;
}

public void setDay(String day) {
    this.day = day;
}

public void setStartTime(String startTime) {
    this.startTime = startTime;
}

public void setEndTime(String endTime) {
    this.endTime = endTime;
}
}
