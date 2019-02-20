package main.java;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		Livre livre = new Livre();

	try {

		    factory = Persistence.createEntityManagerFactory("myBase");
		    em = factory.createEntityManager();
		    
//		    livre = em.find(Livre.class, 1);
//		    if (livre != null){
//
//		    	System.out.println("find :" + livre.getId() );	
//		    }
		    Query query = em.createQuery("select h from	Livre h where h.titre='Germinal'");
		    livre = (Livre) query.getSingleResult();
		    if (livre != null){

		    	System.out.println("Livre :" + livre.getId() + " - " + livre.getAuteur() + " - " + livre.getTitre()  );	
		    }
		    
//			transaction = em.getTransaction();
			
//			transaction.begin();
//			em.createQuery("delete from pizza where code='CAN'").executeUpdate();
//			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();

		} 

	}

}




