package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetList;

public class PetListHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsersAnimalVet");
	
	public void insertPet(PetList pe) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pe);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PetList> showAllPets(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<PetList> allPets = em.createQuery("SELECT i FROM PetList i").getResultList();
		return allPets;
	}
	
	public void deletePet(PetList toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery( "select pe from PetList pe where pe.type = :selectedType and pe.name = :selectedName and pe.owner = :selectedOwner", PetList.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());


		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		PetList result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public PetList searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetList found = em.find(PetList.class, idToEdit);
		em.close();
		return found;
	}

	public List<PetList> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select pe from PetList pe where pe.name = :selectedName", PetList.class);
		typedQuery.setParameter("selectedName", petName);

		List<PetList> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public List<PetList> searchForPetByOwner(String ownerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select pe from PetList pe where pe.owner = :selectedOwner", PetList.class);
		typedQuery.setParameter("selectedOwner", ownerName);

		List<PetList> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public void updatePet(PetList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
