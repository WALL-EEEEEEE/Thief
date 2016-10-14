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
	
	public Employer(){
		
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
	
	public void setName(String name) {
		this.name = name;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+";"+this.dept+";"+this.gender;
	}

	
   
}
