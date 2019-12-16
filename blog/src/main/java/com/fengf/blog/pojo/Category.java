package com.fengf.blog.pojo;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private String categoryAnothername;

    private Integer categoryCount;

    private Integer categoryNum;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryAnothername() {
        return categoryAnothername;
    }

    public void setCategoryAnothername(String categoryAnothername) {
        this.categoryAnothername = categoryAnothername == null ? null : categoryAnothername.trim();
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAnothername='" + categoryAnothername + '\'' +
                ", categoryCount=" + categoryCount +
                ", categoryNum=" + categoryNum +
                '}';
    }
}