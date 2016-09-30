package FrameTest2;
public class Employer {
	private  String name;
	private int gender;
	private String dept;
	
	public Employer(String name,int gender,String dept) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
		this.dept = dept;
	}
	
	public String getGender() {
		return Integer.toString(this.gender);
	}

	public String getDept() {
		return dept;
	}

	public String getName() {
		return this.name;
	}
	

	
   
}
