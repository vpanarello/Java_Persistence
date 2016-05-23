/**
 * 
 */
package dao;

import javax.persistence.*;

/**
 * 20160518-Exercise03-JPA / JpaUtil.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex03_jpa");

	public static EntityManager getEntityManager(){
		return emf.createEntityManager(); 
	}
}
