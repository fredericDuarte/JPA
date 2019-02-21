package main.banque.entite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {

			factory = Persistence.createEntityManagerFactory("myBank");
			em = factory.createEntityManager();
			et = em.getTransaction();
			et.begin();

// ******************************************************************************
// ** TP 4
//  ******************************************************************************	
			// ********** Adresse
			Adresse adr = new Adresse();
			adr.setNumero(85);
			adr.setRue("allée burger");
			adr.setVille("Lyon");
			adr.setCodePostal(69000);

			Adresse adr2 = new Adresse();
			adr2.setNumero(12);
			adr2.setRue("rue du moulin");
			adr2.setVille("Paris");
			adr2.setCodePostal(75000);

			// ********** client
			Client client1 = new Client();
			client1.setNom("Dalton");
			client1.setPrenom("John");
			client1.setAdresse(adr);
			client1.setDateNaissance(LocalDate.of(2000, 5, 5));

			Client client2 = new Client();
			client2.setNom("Dalton");
			client2.setPrenom("Bob");
			client2.setAdresse(adr2);
			client2.setDateNaissance(LocalDate.of(2000, 5, 5));

			List<Client> listClientCA = new ArrayList<>();
			listClientCA.add(client2);

			List<Client> listClientCE = new ArrayList<>();
			listClientCE.add(client1);

			// ********** banque
			Banque ca = new Banque();
			ca.setNom("Credit Agricole");
			ca.setClient(listClientCA);

			Banque ce = new Banque();
			ce.setNom("Caisse Epargne");
			ca.setClient(listClientCE);

			client1.setBanque(ce);
			client2.setBanque(ca);

			/// ************************* tp4 ********************/
			// *********** compte
//			Compte compte1 = new Compte();
//			compte1.setNumero("100200");
//			compte1.setSolde(1225.25);
//
//			Compte compte2 = new Compte();
//			compte2.setNumero("100201");
//			compte2.setSolde(1325.25);
//
//			Compte compte3 = new Compte();
//			compte2.setNumero("50201");
//			compte2.setSolde(2325.45);
//			List<Compte> listCompteCA = new ArrayList<>();
//			listCompteCA.add(compte3);
//			List<Compte> listCompteCE = new ArrayList<>();
//			listCompteCE.add(compte2);
//			listCompteCE.add(compte1);
//
//			client1.setCompte(listCompteCE);
//			client2.setCompte(listCompteCA);
//
//			// ********* operation
//			Operation operation1 = new Operation();
//			operation1.setDate(LocalDateTime.now());
//			operation1.setMotif("premier versement");
//			operation1.setCompteOp(compte3);
//
//			Operation operation2 = new Operation();
//			operation2.setDate(LocalDateTime.now());
//			operation2.setMotif("premier versement");
//			operation2.setCompteOp(compte2);

			/////// **************** tp5 ***********************

			// *********** compte
			LivretA livretA = new LivretA();
			livretA.setNumero("50201");
			livretA.setSolde(2325.45);
			livretA.setTaux(20);
			// livretA.setOperation(listOp);
			livretA.setClientCompte(listClientCE);

			AssuranceVie assurance = new AssuranceVie();
			assurance.setNumero("150201");
			assurance.setSolde(2000.55);
			assurance.setTaux(20);
			assurance.setDateFin(LocalDate.now());
			assurance.setClientCompte(listClientCA);

			List<Compte> listCompteCA = new ArrayList<>();
			listCompteCA.add(assurance);
			List<Compte> listCompteCE = new ArrayList<>();
			listCompteCE.add(livretA);

			client1.setCompte(listCompteCE);
			client2.setCompte(listCompteCA);

			// ********* operation
			Virement virement = new Virement();
			virement.setBeneficiaire("John");
			virement.setDate(LocalDateTime.now());
			virement.setMotif("compte");
			virement.setMontant(1250.32);
			virement.setCompteOp(livretA);

			// ******************** persist ************
			// banque
			em.persist(ca);
			em.persist(ce);
			// client
			em.persist(client1);
			em.persist(client2);
			// compte
			em.persist(livretA);
			em.persist(assurance);
			// operation
			em.persist(virement);

			et.commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
