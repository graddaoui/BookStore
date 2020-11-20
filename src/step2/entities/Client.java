package step2.entities;

public class Client {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String adress;
	private String tel;
	
	public Client() {
		
	}
	
	public Client(int id, String name, String lastName, String email, String adress, String tel) {
		this.id = id;
		this.name = name;
		this.name = lastName;
		this.email = email;
		this.adress = adress;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
