package pl.peersoft;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.peersoft.model.insurance.Client;

public class App {

	public static void main(String[] args) throws InterruptedException {

		final EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("chatPersistenceUnit");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();


		Client existingClient = new Client();
		existingClient.setId(2l);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		existingClient = entityManager.merge(existingClient);
		existingClient.setFirstName("bla2");
		transaction.commit();

	}


	private static List<Client> getClients(EntityManager entityManager) {
		return entityManager
				.createQuery("SELECT c FROM Client c", Client.class)
				.getResultList();
	}


}