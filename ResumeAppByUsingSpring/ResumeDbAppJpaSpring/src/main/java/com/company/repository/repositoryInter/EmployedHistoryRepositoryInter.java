package com.company.repository.repositoryInter;

import com.company.model.EmployedHistory;
import com.company.model.User;

import java.util.List;

public interface EmployedHistoryRepositoryInter {
//    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveEmpHistory(final EmployedHistory empHistory);

    Boolean updateEmpHistory(final EmployedHistory empHistory);

    Boolean removeEmpHistory(final EmployedHistory empHistory);

    List<EmployedHistory> findEmpHistories();

    EmployedHistory findEmpHistoriesById(final Integer empHistoryId);

    List<EmployedHistory> findEmpHistoriesByUser(final User user);

    List<EmployedHistory> findLikeEmpHistory(final String headerHint);

    List<EmployedHistory> findOrderByEmpHistory();


}
