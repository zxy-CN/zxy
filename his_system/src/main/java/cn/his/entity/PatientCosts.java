package cn.his.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PatientCosts implements Serializable {
    private Integer id;

    private Integer registid;

    private Integer invoiceid;

    private Integer itemid;

    private Integer itemtype;

    private String name;

    private BigDecimal price;

    private BigDecimal amount;

    private Integer deptid;

    private Date createtime;

    private Integer createoperid;

    private Date paytime;

    private Integer registerid;

    private Integer feetype;

    private Integer backid;

    public PatientCosts() {
    }

    public PatientCosts(Integer registid, Integer invoiceid, Integer itemid, Integer itemtype, String name, BigDecimal price, BigDecimal amount, Integer deptid, Date createtime, Integer createoperid, Integer registerid, Integer feetype, Integer backid) {
        this.registid = registid;
        this.invoiceid = invoiceid;
        this.itemid = itemid;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.deptid = deptid;
        this.createtime = createtime;
        this.createoperid = createoperid;
        this.registerid = registerid;
        this.feetype = feetype;
        this.itemtype=itemtype;
        this.backid=backid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateoperid() {
        return createoperid;
    }

    public void setCreateoperid(Integer createoperid) {
        this.createoperid = createoperid;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public Integer getFeetype() {
        return feetype;
    }

    public void setFeetype(Integer feetype) {
        this.feetype = feetype;
    }

    public Integer getBackid() {
        return backid;
    }

    public void setBackid(Integer backid) {
        this.backid = backid;
    }
}