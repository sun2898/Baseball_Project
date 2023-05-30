package project01;

public class TeamsVO {

	private String team_name;
	private String owner;
	private String director;
	private String team_leader;
	private String region;
	private String sponser;
	
	public TeamsVO() {	}
	
	public TeamsVO(String team_name, String owner, String director, String team_leader, String region, String sponser) {
		super();
		this.team_name = team_name;
		this.owner = owner;
		this.director = director;
		this.team_leader = team_leader;
		this.region = region;
		this.sponser = sponser;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTeam_leader() {
		return team_leader;
	}

	public void setTeam_leader(String team_leader) {
		this.team_leader = team_leader;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSponser() {
		return sponser;
	}

	public void setSponser(String sponser) {
		this.sponser = sponser;
	}
	
	
	
}
