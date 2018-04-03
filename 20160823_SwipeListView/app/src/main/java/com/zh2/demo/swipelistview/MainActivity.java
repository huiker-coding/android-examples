package com.zh2.demo.swipelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zh2.demo.swipelistview.base.SwipeListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeListView mListView;
    private List<String> restInfoList;
    private mAdapter restAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        iniData();
    }

    private void findViews() {
        mListView = (SwipeListView) findViewById(R.id.listview);
    }

    private void iniData() {
        restInfoList = new ArrayList<>();
        restInfoList.add("饭店NO.1");
        restInfoList.add("饭店NO.2");
        restInfoList.add("饭店NO.3");

        restAdapter=new mAdapter(this,mListView.getRightViewWidth());
        mListView.setAdapter(restAdapter);
    }


    public class mAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private int mRightWidth = 0;

        public mAdapter(Context context, int rightWidth) {
            this.inflater = LayoutInflater.from(context);
            this.mRightWidth = rightWidth;
        }

        @Override
        public int getCount() {
            return restInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return restInfoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (null == holder) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.list_item, null);
                holder.item_left = (RelativeLayout) convertView.findViewById(R.id.item_left);
                holder.item_right = (RelativeLayout) convertView.findViewById(R.id.item_right);
                holder.deleteTv = (TextView) convertView.findViewById(R.id.delete);
                holder.restnameTv = (TextView) convertView.findViewById(R.id.tv_menu_name);
                holder.fixTv = (TextView) convertView.findViewById(R.id.fix);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            holder.item_left.setLayoutParams(lp1);

            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(mRightWidth, LinearLayout.LayoutParams.MATCH_PARENT);
            holder.item_right.setLayoutParams(lp2);

            holder.restnameTv.setText(restInfoList.get(position));

            holder.deleteTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "您点击了删除按钮！", Toast.LENGTH_SHORT).show();
                    mListView.hiddenRight(mListView.mPreItemView);
                }
            });

            holder.fixTv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "您点击了修改按钮！", Toast.LENGTH_SHORT).show();
                    mListView.hiddenRight(mListView.mPreItemView);
                }
            });
            return convertView;
        }

        class ViewHolder {
            public RelativeLayout item_left;
            public RelativeLayout item_right;
            public TextView restnameTv;
            public TextView deleteTv;
            public TextView fixTv;
        }
    }
}
