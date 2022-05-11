package model;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployedHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "header")
    private String header;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Lob
    @Column(name = "jobDesc")
    private String jobDesc;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    public EmployedHistory() {
    }

    public EmployedHistory(String header, Date beginDate, Date endDate, String jobDesc) {
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDesc = jobDesc;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmployedHistory{" +
                "employeeId=" + employeeId +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDesc='" + jobDesc + '\'' +
                '}';
    }
}
