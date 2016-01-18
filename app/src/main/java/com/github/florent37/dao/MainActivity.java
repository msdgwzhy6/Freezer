package com.github.florent37.dao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.florent37.dao.model.Car;
import com.github.florent37.dao.model.User;
import com.github.florent37.dao.model.UserDAO;

public class MainActivity extends AppCompatActivity {

    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDAO = new UserDAO();

        userDAO.add(new User(3, new Car("florent")));
        userDAO.add(new User(20, new Car("kévin")));
        userDAO.add(new User(10, new Car("alex")));

        Log.d("DAO all", userDAO.selectWhere()
                .asList()
                .toString());
    }
}
