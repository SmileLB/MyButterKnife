package com.example.administrator.mybutterknife.example;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by LiBing
 * on 2017/10/12 0012
 * describe:
 */

public class ButterKnife {

    public static void bind(Activity activity) {
        try {
            bindView(activity);
            bindOnClick(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bindView(Activity activity) throws IllegalAccessException {
        //1、获取字节码
        Class<? extends Activity> aClass = activity.getClass();
        //2、获取activity中的所有变量
        Field[] declaredFields = aClass.getDeclaredFields();
        //3、遍历变量数组
        for (Field field : declaredFields) {
            //允许暴力反射
            field.setAccessible(true);
            //获取变量上的注解
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation != null) {
                //获取注解上的值
                int id = annotation.value();
                //通过ID获取控件
                View view = activity.findViewById(id);
                //给字段赋值
                field.set(activity, view);
            }
        }
    }

    private static void bindOnClick(final Activity activity) {
        //1、获取字节码
        Class<? extends Activity> aClass = activity.getClass();
        //2、获取activity中的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        //3、遍历方法数组
        for (final Method method : declaredMethods) {
            method.setAccessible(true);
            OnClick annotation = method.getAnnotation(OnClick.class);
            if (annotation != null) {
                int id = annotation.value();
                View view = activity.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            method.invoke(activity,null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
