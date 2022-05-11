package service.serviceImpl;

import model.EmployedHistory;
import model.User;
import repository.repositoryImpl.EmployedHistoryRepositoryImpl;
import repository.repositoryInter.EmployedHistoryRepositoryInter;
import service.serviceInter.EmployedHistoryServiceInter;

import java.util.List;

public class EmployedHistoryServiceImpl implements EmployedHistoryServiceInter {
    private EmployedHistoryRepositoryInter employedHistoryRepositoryInter = new EmployedHistoryRepositoryImpl();

    @Override
    public Boolean saveEmpHistory(EmployedHistory empHistory) {
        return this.employedHistoryRepositoryInter.saveEmpHistory(empHistory);
    }

    @Override
    public Boolean updateEmpHistory(EmployedHistory empHistory) {
        return this.employedHistoryRepositoryInter.updateEmpHistory(empHistory);
    }

    @Override
    public Boolean removeEmpHistory(EmployedHistory empHistory) {
        return this.employedHistoryRepositoryInter.removeEmpHistory(empHistory);
    }

    @Override
    public List<EmployedHistory> findEmpHistories() {
        return this.employedHistoryRepositoryInter.findEmpHistories();
    }

    @Override
    public EmployedHistory findEmpHistoriesById(Integer empHistoryId) {
        return this.employedHistoryRepositoryInter.findEmpHistoriesById(empHistoryId);
    }

    @Override
    public List<EmployedHistory> findEmpHistoriesByUser(User user) {
        return this.employedHistoryRepositoryInter.findEmpHistoriesByUser(user);
    }

    @Override
    public List<EmployedHistory> findLikeEmpHistory(String headerHint) {
        return this.employedHistoryRepositoryInter.findLikeEmpHistory(headerHint);
    }

    @Override
    public List<EmployedHistory> findOrderByEmpHistory() {
        return this.employedHistoryRepositoryInter.findOrderByEmpHistory();
    }
}
