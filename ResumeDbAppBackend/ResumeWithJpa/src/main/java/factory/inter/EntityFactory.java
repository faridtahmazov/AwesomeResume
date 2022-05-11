package factory.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface EntityFactory {
    EntityManager getEntityManager();

    EntityTransaction getTransaction();
}
