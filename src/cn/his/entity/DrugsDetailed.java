package cn.his.entity;

public class DrugsDetailed {
    private Integer id; //成药模板明细id

    private Integer drugstempid; //成药模板id nn

    private Integer drugsid;//药品id nn

    private String drugsusage;//用法

    private String dosage;//用量

    private String frequency;//频次
    
    private Drugs drugs;//药品对象 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrugstempid() {
        return drugstempid;
    }

    public void setDrugstempid(Integer drugstempid) {
        this.drugstempid = drugstempid;
    }

    public Integer getDrugsid() {
        return drugsid;
    }

    public void setDrugsid(Integer drugsid) {
        this.drugsid = drugsid;
    }

    public String getDrugsusage() {
        return drugsusage;
    }

    public void setDrugsusage(String drugsusage) {
        this.drugsusage = drugsusage == null ? null : drugsusage.trim();
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage == null ? null : dosage.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

	public Drugs getDrugs() {
		return drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}
}