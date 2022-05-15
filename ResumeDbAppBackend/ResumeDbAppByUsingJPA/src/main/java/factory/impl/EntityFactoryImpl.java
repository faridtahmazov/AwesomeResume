package factory.impl;

import factory.inter.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityFactoryImpl implements EntityFactory {
    private EntityManager entityManager;
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        entityManager = factory.createEntityManager();

        return entityManager;
    }

    @Override
    public EntityTransaction getTransaction() {
        EntityTransaction transaction = getEntityManager().getTransaction();

        return transaction;
    }
}
