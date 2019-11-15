package cn.his.entity;

public class CheckRelation {
    private Integer id;

    private Integer checkprojid;

    private Integer checktempid;

    private String position;

    private FmedItem fmedItem;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckprojid() {
        return checkprojid;
    }

    public void setCheckprojid(Integer checkprojid) {
        this.checkprojid = checkprojid;
    }

    public Integer getChecktempid() {
        return checktempid;
    }

    public void setChecktempid(Integer checktempid) {
        this.checktempid = checktempid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

	public FmedItem getFmedItem() {
		return fmedItem;
	}

	public void setFmedItem(FmedItem fmedItem) {
		this.fmedItem = fmedItem;
	}
}