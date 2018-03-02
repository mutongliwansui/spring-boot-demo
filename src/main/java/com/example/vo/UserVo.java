package com.example.vo;

import com.example.validation.CommonRegular;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserVo {
    @CommonRegular(regexp = "[\\u4e00-\\u9fa5]{0,5}",message = "不符合姓名规范")
    private String name;
    private double height;
    private double weight;
    @NotNull(message = "生日不能为空")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
