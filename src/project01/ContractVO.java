package project01;

public class ContractVO extends PlayersVO {

	private int p_code;
	private String p_name;
	private String p_position;
	private int salary;
	private String currTeam;
	private String newTeam;
	private int down_payment;
	private String yn;
	
	
	public ContractVO() {}
	
	public ContractVO(int p_code, String p_name, String p_position, int salary, String currTeam, String newTeam,
			int down_payment, String yn) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_position = p_position;
		this.salary = salary;
		this.currTeam = currTeam;
		this.newTeam = newTeam;
		this.down_payment = down_payment;
		this.yn = yn;
	}
	
	public ContractVO(int p_code) {
		super();
		this.p_code = p_code;
	}
	
	public ContractVO(int p_code, String p_name, String p_position, int height, int score, int join_year, double serve, double blocking, double receive, double p_set, String newTeam) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_position = p_position;
		super.setHeight(height);
		super.setScore(score);
		super.setJoin_year(join_year);
		super.setServe(serve);
		super.setBlocking(blocking);
		super.setReceive(receive);
		super.setP_set(p_set);
		this.newTeam = newTeam;
	}
	

	public int getP_code() {
		return p_code;
	}

	public void setP_code(int p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_position() {
		return p_position;
	}

	public void setP_position(String p_position) {
		this.p_position = p_position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCurrTeam() {
		return currTeam;
	}

	public void setCurrTeam(String currTeam) {
		this.currTeam = currTeam;
	}

	public String getNewTeam() {
		return newTeam;
	}

	public void setNewtream(String newTeam) {
		this.newTeam = newTeam;
	}

	public int getDown_payment() {
		return down_payment;
	}

	public void setDown_payment(int down_payment) {
		this.down_payment = down_payment;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

}
