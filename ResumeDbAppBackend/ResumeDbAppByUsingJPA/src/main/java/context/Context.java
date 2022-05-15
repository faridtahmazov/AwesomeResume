package context;

import repository.repositoryImpl.EmployedHistoryRepositoryImpl;
import repository.repositoryImpl.SkillRepositoryImpl;
import repository.repositoryImpl.UserRepositoryImpl;
import repository.repositoryInter.EmployedHistoryRepositoryInter;
import repository.repositoryInter.SkillRepositoryInter;
import repository.repositoryInter.UserRepositoryInter;

public class Context {
    public UserRepositoryInter getInstanceUserRepository(){
        return new UserRepositoryImpl();
    }

    public SkillRepositoryInter getInstanceSkillRepository(){
        return new SkillRepositoryImpl();
    }

    public EmployedHistoryRepositoryInter getInstanceEmployedHistoryRepository(){
        return new EmployedHistoryRepositoryImpl();
    }
}
