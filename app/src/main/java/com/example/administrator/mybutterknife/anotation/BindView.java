package com.example.administrator.mybutterknife.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by LiBing
 * on 2017/10/10 0010
 * describe:
 */
//@Target(ElementType.FIELD)//定义当前注解使用在变量上
//@Target(ElementType.METHOD)//定义当前注解使用在方法上
//@Retention(RetentionPolicy.SOURCE)//该注解存在于源码中，当源码被编译成字节码的时候，该注解被清除
//@Retention(RetentionPolicy.CLASS)//该注解存在于字节码中，当源码被编译成字节码的时候，该注解不会被清除
@Retention(RetentionPolicy.RUNTIME)//表示当前注解存在与java虚拟机中
@Target(ElementType.FIELD)
public @interface BindView {

    String name();

    int age();

}
