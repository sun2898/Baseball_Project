package project01;

public class SttafVO {

	private String team_name;
	private String s_name;
	private String s_position;
	private String task;
	
	public SttafVO() {};
	
	public SttafVO(String team_name, String s_name, String s_position) {
		super();
		this.team_name = team_name;
		this.s_name = s_name;
		this.s_position = s_position;
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
