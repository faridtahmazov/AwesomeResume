package repository.repositoryImpl;

import model.EmployedHistory;
import model.User;
import queries.EmployedHistoryQuery;
import repository.repositoryInter.EmployedHistoryRepositoryInter;

import javax.persistence.*;
import java.util.List;

public class EmployedHistoryRepositoryImpl implements EmployedHistoryRepositoryInter {

    EntityManager entityManager = entityFactory.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Boolean saveEmpHistory(EmployedHistory empHistory) {
        try{
            this.transaction.begin();
            this.entityManager.persist(empHistory);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: ");
            try {
                transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateEmpHistory(EmployedHistory empHistory) {
        try{
            this.transaction.begin();
            this.entityManager.persist(empHistory);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: ");
            try {
                transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeEmpHistory(EmployedHistory empHistory) {
        try {
            if (this.entityManager.contains(empHistory)){
                this.entityManager.remove(empHistory);
            }else {
                EmployedHistory deletedEmpHistory = findEmpHistoriesById(empHistory.getEmployeeId());
                this.entityManager.remove(deletedEmpHistory);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public List<EmployedHistory> findEmpHistories() {
        List<EmployedHistory> employedHistories = null;
        try{
            TypedQuery<EmployedHistory> typedQuery = this.entityManager.
                    createQuery(EmployedHistoryQuery.findEmpHistories, EmployedHistory.class);
            employedHistories = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }

        return employedHistories;
    }

    @Override
    public EmployedHistory findEmpHistoriesById(Integer empHistoryId) {
        EmployedHistory employedHistory = null;
        try{
            TypedQuery<EmployedHistory> typedQuery = this.entityManager.
                    createQuery(EmployedHistoryQuery.findEmpHistoriesById, EmployedHistory.class);
            typedQuery.setParameter("empHistoryId", empHistoryId);
            employedHistory = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }

        return employedHistory;
    }

    @Override
    public List<EmployedHistory> findEmpHistoriesByUser(User user) {
        List<EmployedHistory> employedHistories = null;
        try{
            TypedQuery<EmployedHistory> typedQuery = this.entityManager.
                    createQuery(EmployedHistoryQuery.findEmpHistoriesByUser, EmployedHistory.class);
            typedQuery.setParameter("userId", user.getUserId());
            employedHistories = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }

        return employedHistories;
    }

    @Override
    public List<EmployedHistory> findLikeEmpHistory(String headerHint) {
        List<EmployedHistory> employedHistories = null;
        try{
            TypedQuery<EmployedHistory> typedQuery = this.entityManager.
                    createQuery(EmployedHistoryQuery.findLikeEmpHistory, EmployedHistory.class);
            typedQuery.setParameter("headerHint", headerHint);
            employedHistories = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }

        return employedHistories;
    }

    @Override
    public List<EmployedHistory> findOrderByEmpHistory() {
        List<EmployedHistory> employedHistories = null;
        try{
            TypedQuery<EmployedHistory> typedQuery = this.entityManager.
                    createQuery(EmployedHistoryQuery.findOrderByEmpHistory, EmployedHistory.class);
            employedHistories = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }

        return employedHistories;
    }
}
