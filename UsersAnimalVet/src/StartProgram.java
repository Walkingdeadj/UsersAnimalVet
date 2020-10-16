import java.util.List;
import java.util.Scanner;
import controller.PetListHelper;
import model.PetList;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static PetListHelper petl = new PetListHelper();
	
	private static void addAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter a type: ");
		String type = in.nextLine();
		System.out.print("Enter an name: ");
		String name = in.nextLine();
		System.out.print("Enter the owner: ");
		String owner = in.nextLine();
		
		PetList toAdd = new PetList(type, name, owner);
		petl.insertPet(toAdd);
	}
	
	private static void deleteAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter the type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the owner to delete: ");
		String owner = in.nextLine();
		
		PetList toDelete = new PetList(type, name, owner);
		petl.deletePet(toDelete);
	}
	
	private static void editAPet() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Owner");
		int searchBy = in.nextInt();
		in.nextLine();
		List<PetList> foundPets;
		if (searchBy == 1) {
			System.out.print("Enter the pet's name: ");
			String petName = in.nextLine();
			foundPets = petl.searchForPetByName(petName);
		} else {
			System.out.print("Enter the owner's name: ");
			String OwnerName = in.nextLine();
			foundPets = petl.searchForPetByOwner(OwnerName);
		}

		if (!foundPets.isEmpty()) {
			System.out.println("Found Results.");
			for (PetList l : foundPets) {
				System.out.println(l.getId() + " : " + l.returnPetDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			PetList toEdit = petl.searchForPetById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getOwner());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Owner");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newStore = in.nextLine();
				toEdit.setName(newStore);
			} else if (update == 2) {
				System.out.print("New Owner: ");
				String newItem = in.nextLine();
				toEdit.setOwner(newItem);
			}

			petl.updatePet(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
	
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<PetList> allPets = petl.showAllPets();
		for(PetList singlePet : allPets){
			System.out.println(singlePet.returnPetDetails());
		}
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our new animal vet! ---");
		while (goAgain) {
			System.out.println("*  Select your choice:");
			System.out.println("*  1 -- Add a pet's file");
			System.out.println("*  2 -- Edit a pet's file");
			System.out.println("*  3 -- Delete a pet's file");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPet();
			} else if (selection == 2) {
				editAPet();
			} else if (selection == 3) {
				deleteAPet();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//lih.cleanUp();
				System.out.println("   Thank you for your visit!   ");
				goAgain = false;
			}

		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}
}
