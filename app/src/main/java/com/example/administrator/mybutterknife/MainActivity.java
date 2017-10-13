package com.example.administrator.mybutterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mybutterknife.example.BindView;
import com.example.administrator.mybutterknife.example.ButterKnife;
import com.example.administrator.mybutterknife.example.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    private TextView tv1;
    @BindView(R.id.tv2)
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toast.makeText(this, tv1.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn)
    public void onClick(){
        Toast.makeText(this, tv1.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reflect();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anotation();
            }
        });
    }

    private void anotation() {
        //1、创建student对象
        Student student = new Student();
        ButterKnife.bind(student);
    }

    private void reflect() {
        *//******************获取类对象*******************//*

        //方法1
        Class clazz1 = User.class;

        //方法2
        try {
            Class clazz2 = Class.forName("com.example.administrator.mybutterknife.User");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方法3
        User user = new User("李易峰", 30);
        Class clazz3 = user.getClass();

        try {
            //得到成员变量对象
            //getField只能得到Public
            Field fieldAge = clazz3.getField("age");
            //getDeclaredField可以取出private
            Field fieldName = clazz3.getDeclaredField("name");
            //允许对对象进行操作(暴力反射)
            fieldName.setAccessible(true);
            //获取字段的值
            String name = (String) fieldName.get(user);
            int age = fieldAge.getInt(user);

            Log.e("---------------", name + "-----" + age);

            *//*******************修改对象中变量的值*******************//*
            fieldName.set(user, "刘亦菲");
            fieldAge.setInt(user, 40);
            String name2 = (String) fieldName.get(user);
            int age2 = fieldAge.getInt(user);
            Log.e("---------------", name2 + "-----" + age2);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        *//******************对象中的方法*******************//*
        //取出所有方法
        *//*Method[] methods = clazz3.getMethods();
        for (Method method : methods) {
            Log.e("---------------", method.getName());
        }*//*

        try {
            //取到eat方法参数一，方法名称，参数二：参数类型
            Method eat = clazz3.getMethod("eat", String.class);
            //调用方法
            eat.invoke(user, "米饭");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/
}
