package org.profamilia.hc.view.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

@Component
public class EntityManager {

	public static final String MAIN_ENTITI_MANAGER = "main";

	public static final String SECOND_ENTITI_MANAGER = "second";

	@Autowired
	@Qualifier("mainEntityManager")
	private javax.persistence.EntityManager mainDatabase;

	@Autowired
	@Qualifier("secondEntityManager")
	private javax.persistence.EntityManager secondDatabase;

	@Autowired
	@Qualifier("thirdEntityManager")
	private javax.persistence.EntityManager thirdDatabase;

	public javax.persistence.EntityManager getEm(String url) {

		if (url.contains("main")) {
			return mainDatabase;
		}
		if (url.contains("second")) {
			return secondDatabase;
		}
		if (url.contains("third")) {
			return thirdDatabase;
		}
		return mainDatabase;
	}

	public JpaRepositoryFactory getJpaFactory(String url) {
		return new JpaRepositoryFactory(getEm(url));
	}

}