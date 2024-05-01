package team11.Dyson.domian;

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

    /**
     * 获取
     * @return modId
     */
    public Integer getModId() {
        return modId;
    }

    /**
     * 设置
     * @param modId
     */
    public void setModId(Integer modId) {
        this.modId = modId;
    }

    /**
     * 获取
     * @return modName
     */
    public String getModName() {
        return modName;
    }

    /**
     * 设置
     * @param modName
     */
    public void setModName(String modName) {
        this.modName = modName;
    }

    /**
     * 获取
     * @return proId
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * 设置
     * @param proId
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * 获取
     * @return examId
     */
    public Integer getExamId() {
        return examId;
    }

    /**
     * 设置
     * @param examId
     */
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Modules{modId = " + modId + ", modName = " + modName + ", proId = " + proId + ", examId = " + examId + ", description = " + description + "}";
    }
}
