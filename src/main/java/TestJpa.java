package main.java;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		Livre livre = new Livre();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

		try {

			factory = Persistence.createEntityManagerFactory("myBase");
			em = factory.createEntityManager();
//  ******************************************************************************		    
//		    livre = em.find(Livre.class, 1);
//		    if (livre != null){
//
//		    	System.out.println("find :" + livre.getId() );	
//		    }
//  ******************************************************************************				    
// 			Query query = em.createQuery("select h from Livre h where
//          h.titre='Germinal'");
//		    livre = (Livre) query.getSingleResult(); 
//		    livre = (Livre) query.getSingleResult(); 
//		    if (livre != null){
//
//		    	System.out.println("Livre :" + livre.getId() + " a pris - " + livre.getAuteur() + " - " + livre.getTitre()  );	
//		    }
//  ******************************************************************************			    
			String sql2 = "select e" + " from Emprunt e" + " where e.id = 2";

			List<Emprunt> emp = em.createQuery(sql2, Emprunt.class).getResultList();

			// emp.forEach(System.out::println);

			for (Emprunt e : emp) {
				// List<Livre> liv = e.getLivre().stream().collect(Collectors.toList());
				List<Livre> liv = e.getLivre();
				for (Livre l : liv) {
					System.out.println(" Monsieur " + e.getClient().getNom() + " a emprunté le  "
							+ e.getDate_debut().format(formatter) + " , le livre " + l.getTitre());

				}

			}

//  ******************************************************************************			

			String sql3 = "select c" + " from Client c" + " where c.id = 2";

			List<Client> cli = em.createQuery(sql3, Client.class).getResultList();

			for (Client e : cli) {

				List<Emprunt> pret = e.getEmprunt();
				for (Emprunt l : pret) {
					System.out.println(
							" Monsieur " + e.getNom() + " a emprunté le  " + l.getDate_debut().format(formatter));
				}
			}

//  ******************************************************************************				

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
