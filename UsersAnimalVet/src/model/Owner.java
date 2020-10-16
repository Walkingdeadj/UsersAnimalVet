package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OWNER_ID")
	private int id;
	@Column(name="OWNER_PHONENUMBER")
	private String ownerPNum;
	
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Owner(int id, String ownerPNum) {
		super();
		this.id = id;
		this.ownerPNum = ownerPNum;
	}
	
	public Owner(String ownerPNum) {
		super();
		this.ownerPNum = ownerPNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerPNum() {
		return ownerPNum;
	}
	public void setOwnerPNum(String ownerPNum) {
		this.ownerPNum = ownerPNum;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerPhoneNumber" + ownerPNum + "]";
	}
}
