package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;
import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsersAnimalVet");
		public void insertShopper(Owner o) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			em.close();
		}
		public List<Owner> showAllOwners() {
			EntityManager em = emfactory.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
			return allOwners;
		}
		
		public void updateList(ListDetails toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
		
		public Owner findOwner(String PNumToLookUp) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Owner> typedQuery = em.createQuery("select sh from Owner sh where sh.ownerPNum = :selectedownerPNum",Owner.class);
			typedQuery.setParameter("selectedownerPNum", PNumToLookUp);
			Owner foundShopper;
			try {
				foundShopper = typedQuery.getSingleResult();
			} catch (NoResultException ex) {
			foundShopper = new Owner(PNumToLookUp);
			}
			em.close();
			return foundShopper;
		}
	
}
