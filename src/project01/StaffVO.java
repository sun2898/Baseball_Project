package project01;

public class StaffVO {

	private int s_code;
	private String team_name;
	private String s_name;
	private String s_position;
	private String task;
	
	
	public StaffVO() {}

	public StaffVO(int s_code, String team_name, String s_name, String s_position) {
		super();
		this.s_code = s_code;
		this.team_name = team_name;
		this.s_name = s_name;
		this.s_position = s_position;
	}

	public StaffVO(int s_code, String team_name, String s_name, String s_position, String task) {
		super();
		this.s_code = s_code;
		this.team_name = team_name;
		this.s_name = s_name;
		this.s_position = s_position;
		this.task = task;
	}
	
	public StaffVO(String team_name, String s_name, String s_position, String task) {
		super();
		this.team_name = team_name;
		this.s_name = s_name;
		this.s_position = s_position;
		this.task = task;
	}
	
	public StaffVO(int s_code) {
		super();
		this.s_code = s_code;
	}
	

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_position() {
		return s_position;
	}

	public void setS_position(String s_position) {
		this.s_position = s_position;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}


}
