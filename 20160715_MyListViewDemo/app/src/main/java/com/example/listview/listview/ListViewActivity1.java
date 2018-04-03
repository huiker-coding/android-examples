package com.example.listview.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity1 extends AppCompatActivity {
    private ListView listView;
    private List<UserInfo> userInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity1);

        findViews();
        initData();

    }

    private void findViews() {
        listView = (ListView) findViewById(R.id.listview1);
    }

    private void initData() {
        userInfoList=new ArrayList<>();
    }

    class UserInfoAdapter extends BaseAdapter{
        public UserInfoAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

        class ViewHolder{
            public TextView tv_name;
            public TextView tv_age;
            public TextView tv_score;
            public Button btn_commit;
        }
    }
}


class UserInfo {
    private String name;
    private int age;
    private float score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
