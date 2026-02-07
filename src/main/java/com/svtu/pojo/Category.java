package com.svtu.pojo;

/**
 * 分类实体类，对应t_category表
 */
public class Category {
    private Integer id;   // 主键ID
    private String name;  // 分类名称

    // 无参构造
    public Category() {}

    // 有参构造（name）
    public Category(String name) {
        this.name = name;
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
