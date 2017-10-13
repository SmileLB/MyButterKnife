package com.example.administrator.mybutterknife.anotation;

import java.lang.reflect.Field;

/**
 * Created by LiBing
 * on 2017/10/11 0011
 * describe:对使用了注解类的类进行反射操作的类
 */
public class ButterKnife {

    public static void bind(Student student) {
        //2、获取student对象对应的字节码
        Class clazz = student.getClass();

        try {
            //3、通过反射拿到name和age
            Field fieldName = clazz.getDeclaredField("name");
            Field fieldAge = clazz.getDeclaredField("age");
            //允许暴力反射
            fieldName.setAccessible(true);
            fieldAge.setAccessible(true);

            //获取name字段的注解
            BindView bindView = fieldName.getAnnotation(BindView.class);

            if (bindView != null) {
                //获取注解的值
                String name = bindView.name();
                int age = bindView.age();
                //设置对象的属性值
                fieldName.set(student, name);
                fieldAge.setInt(student, age);
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
