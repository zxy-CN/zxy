package cn.his.entity;

import java.util.Date;

/**
 * 医技处置时查询所用的实体类
 */
public class CheckNameList {
    private String caseNumber;
    private String RealName;
    private String ConstantName;
    private String SettleName;
    private String UserName;
    private Integer Age;
    private String DeptName;
    private Date creationtime;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getConstantName() {
        return ConstantName;
    }

    public void setConstantName(String constantName) {
        ConstantName = constantName;
    }

    public String getSettleName() {
        return SettleName;
    }

    public void setSettleName(String settleName) {
        SettleName = settleName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }
}
