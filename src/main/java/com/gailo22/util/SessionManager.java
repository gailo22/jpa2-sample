package com.gailo22.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager {
	public static EntityManager getEntityManager() {
		final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("book");
		return managerFactory.createEntityManager();
	}

}
