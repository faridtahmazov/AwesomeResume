import daoClass.EmpDaoClass;
import daoInter.EmpDaoInter;
import daoClass.SkillDaoClass;
import daoInter.SkillDaoInter;
import daoClass.UserDaoClass;
import daoInter.UserDaoInter;
import daoClass.UserSkillDaoClass;
import daoInter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter getInstanceUserDao(){
        return new UserDaoClass();
    }

    public static UserSkillDaoInter getInstanceUserSkillDao(){
        return new UserSkillDaoClass();
    }

    public static EmpDaoInter getInstanceEmployedHistoryDao(){
        return new EmpDaoClass();
    }

    public static SkillDaoInter getInstanceSkillDao(){
        return new SkillDaoClass();
    }

}
