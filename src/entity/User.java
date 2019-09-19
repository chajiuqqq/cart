package entity;

public class User {
	int id;
	String name;
	String username;
	String password;
	
	public User(int aid,String aname,String ausername,String apassword) {
		// TODO Auto-generated constructor stub
		id=aid;
		name=aname;
		username=ausername;
		password=apassword;
	}
	
	public User(String aname,String ausername,String apassword) {
		// TODO Auto-generated constructor stub
		this(0, aname, ausername, apassword);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[username: "+username+" pw: "+password+"]";
	}
}
