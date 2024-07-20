package models;

public class employee extends deptmodel {

	private int empid;
	private String empname;
	private String empemail;
	private String empcontact ;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmpcontact() {
		return empcontact;
	}
	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}
	
}
