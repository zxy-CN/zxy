package cn.his.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VChargeHerbal  implements Serializable {
    private String casenumber;

    private String realname;

    private String idnumber;

    private String homeaddress;

    private Date creationtime;

    private Integer state;

    private String dosage;

    private String drugsname;

    private BigDecimal drugsprice;

    private Integer doctorid;

    private Integer id;

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage == null ? null : dosage.trim();
    }

    public String getDrugsname() {
        return drugsname;
    }

    public void setDrugsname(String drugsname) {
        this.drugsname = drugsname == null ? null : drugsname.trim();
    }

    public BigDecimal getDrugsprice() {
        return drugsprice;
    }

    public void setDrugsprice(BigDecimal drugsprice) {
        this.drugsprice = drugsprice;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}