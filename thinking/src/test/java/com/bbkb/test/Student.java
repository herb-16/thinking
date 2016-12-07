package com.bbkb.test;


import com.bbkb.custom.CaseMode;
import com.bbkb.custom.CheckCase;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.engine.groups.Group;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/15<br>
 */
//如果你想覆盖默认的 Default 验证，那么可以在验证的类上使用@GroupSequence 注解，但
//        要注意序列中必须包含当前的类，且不能包含 Default 组别。
//@GroupSequence({Student.class, Group1.class})
public class Student implements Comparable<Student> {

//    @NotNull(groups = {Group1.class, Group2.class}, message = "id不能为空")
    private Long id;

//
//    @NotNull
//    @Size(min = 1,max = 20,message = "名字的长度必须在{min}和{max}之间",
//    groups = {Group2.class})

//    @Size(min = 1, max = 20, groups = Group1.class)

//    @CheckCase(key = "姓名",value = CaseMode.UPPER)
    @CheckCase.List({
            @CheckCase(key = "姓名",value = CaseMode.UPPER,groups = Group1.class),
            @CheckCase(key = "姓名",value = CaseMode.LOWER,groups = Group2.class)
    })
    private String name;

//    @Min(1)
//    @Max(100)
    private Integer score;

//    @NotBlank(message = "备注不能为空")
    private String remark;

//    @NotNull(groups = {Group1.class}, message = "地址不能为空")
//    @Valid
    private Address address;

    public Student() {
    }

    public Student(Long id, String name, Integer score, String remark) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.remark = remark;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score) {
            return 1;
        } else if (this.score < o.score) {
            return -1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                '}';
    }

//    如果你的应用中存在多个 JSR 303 的实现（在 Jboss、Weblogic、Websphere 中出现这种情况
//    的可能比较多） ，你想显示的指定某一个实现，那么需要使用如下的方式：
//    Configuration<HibernateValidatorConfiguration> config = Validation.byProvider(HibernateValidator.class).configure();
//    static ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
//    static Validator validator = validationFactory.getValidator();


    //    初始化验证器（默认方式创建验证工厂：检索类路径下的所有jar文件，查找 META-INF/services/目录中的 javax.validation.spi.ValidationProvider 文件中的
//    验证提供器的类名）
//    由于我们使用的是 Hibernate Validator 作为底层实现，所以它会加载
//    org.hibernate.validator.HibernateValidator类
    static ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
    static Validator validator = validationFactory.getValidator();
    //Validator 是一个线程安全，并且可以被缓存的类

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "a";
        student.score = 29;
        student.remark = "备注";
        student.address = new Address();


//        1、验证整个实例
        Set<ConstraintViolation<Student>> set = validator.validate(student,Group2.class);

//       4、验证组
//        Set<ConstraintViolation<Student>> set = validator.validate(student,Group1.class);

//        5、组别序列
//        Set<ConstraintViolation<Student>> set = validator.validate(student,Group3.class);

        for (ConstraintViolation<Student> cs : set) {
            System.out.println(cs.getMessage());
        }


//        2、验证某个属性
//        Set<ConstraintViolation<Student>> set = validator.validateProperty(student,"name");
//        for (ConstraintViolation<Student> cs:set){
//            System.out.println(cs.getMessage());
//        }


//        3、验证某个属性的某个值 （验证的递归性对2，3方法无效）
//        Set<? extends ConstraintViolation<? extends Student>> set = validator.validateValue(student.getClass(),"name","");
//        for (ConstraintViolation<? extends Student> cs:set){
//            System.out.println(cs.getMessage());
//        }
//        System.out.println(student.score);

//        4、验证组

    }
}
