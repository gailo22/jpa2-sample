import javax.persistence.EntityManager;

import org.junit.Test;

import com.gailo22.util.SessionManager;

import static org.junit.Assert.assertNotNull;

public class EntityManagerTest {

	@Test
	public void shouldNotNull() {
		final EntityManager em = SessionManager.getEntityManager();
		assertNotNull(em);
	}

}
