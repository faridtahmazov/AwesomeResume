package com.company.service.serviceImpl;

import com.company.model.EmployedHistory;
import com.company.model.User;
import com.company.repository.repositoryImpl.EmployedHistoryRepositoryImpl;
import com.company.repository.repositoryInter.EmployedHistoryRepositoryInter;
import com.company.service.serviceInter.EmployedHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployedHistoryServiceImpl implements EmployedHistoryServiceInter {
    @Autowired(required = false)
    @Qualifier("employedHistoryRepositoryImpl")
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
