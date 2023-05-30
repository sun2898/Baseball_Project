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
	
	public ContractVO(int p_code, String p_name, String p_position, int salary, String currteam, String newtream,
			int down_payment, String yn) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_position = p_position;
		this.salary = salary;
		this.currTeam = currteam;
		this.newTeam = newtream;
		this.down_payment = down_payment;
		this.yn = yn;
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

	public String getCurrteam() {
		return currTeam;
	}

	public void setCurrteam(String currteam) {
		this.currTeam = currteam;
	}

	public String getNewtream() {
		return newTeam;
	}

	public void setNewtream(String newtream) {
		this.newTeam = newtream;
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
