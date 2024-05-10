package team11.Dyson.domain;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */

public class
Modules {
    private Integer modId;
    private String modName;
    private Integer proId;
    private Integer examId;
    private String description;


    public Modules() {
    }

    public Modules(Integer modId, String modName, Integer proId, Integer examId, String description) {
        this.modId = modId;
        this.modName = modName;
        this.proId = proId;
        this.examId = examId;
        this.description = description;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Modules{modId = " + modId + ", modName = " + modName + ", proId = " + proId + ", examId = " + examId + ", description = " + description + "}";
    }
}
