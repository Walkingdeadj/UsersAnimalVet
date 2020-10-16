package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="VISIT_DATE")
	private LocalDate visitDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="ITEMS_ON_LIST",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="PET_ID", referencedColumnName="ID", unique=true) }
	  )
	private List<PetList> listOfPets;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, LocalDate visitDate, Owner owner, List<PetList> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.visitDate = visitDate;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, LocalDate visitDate, Owner owner, List<PetList> listOfPets) {
		super();
		this.listName = listName;
		this.visitDate = visitDate;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, LocalDate visitDate, Owner owner) {
		super();
		this.listName = listName;
		this.visitDate = visitDate;
		this.owner = owner;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public List<PetList> getListOfPets() {
		return listOfPets;
	}


	public void setListOfPets(List<PetList> listOfPets) {
		this.listOfPets = listOfPets;
	}


	@Override
	public String toString() {
		return "OwnerListDetails [id=" + id + ", ListName=" + listName + ", visitDate=" + visitDate + ", owner=" + owner + ", listOfPets=" + listOfPets + "]";
	}
}
