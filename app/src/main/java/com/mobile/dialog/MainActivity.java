package com.mobile.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RightItemAdapter mrightItemAdapter;
    GridView gridview ;
    List<RightItemModel> rightItemModelList = new ArrayList<>();
    List<String> countryCodeSum = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
                // 设置style 控制默认dialog带来的边距问题
                final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogTheme);
                dialog.setContentView(view);


                gridview = (GridView) view.findViewById(R.id.gridview);
                TextView cancel = (TextView) view.findViewById(R.id.cancel);

                // 初始化网格表
                countryCodeSum.clear();
                rightItemModelList.clear();
                countryCodeSum.add("关闭");
                countryCodeSum.add("刷新");
                countryCodeSum.add("最小化");
                countryCodeSum.add("批量审批");
                countryCodeSum.add("批量审批");
                for (int i = 0; i < countryCodeSum.size(); i++) {
                    Drawable drawable= getResources().getDrawable(R.drawable.common_minisize);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    RightItemModel rightItemModel = new RightItemModel(countryCodeSum.get(i),drawable);
                    rightItemModelList.add(rightItemModel);
                }
                mrightItemAdapter = new RightItemAdapter(MainActivity.this, rightItemModelList);
                gridview.setAdapter(mrightItemAdapter);


                // 取消按钮
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                // 添加item点击事件
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                       // String[] provincess = getResources().getStringArray(R.array.licence_province);
                        Toast.makeText(getApplicationContext(), "你按下了" + arg2, Toast.LENGTH_SHORT).show();
                        TextView textView=arg1.findViewById(R.id.text_view);
                        textView.setText("hahahha");
                        dialog.dismiss();
                    }
                });

                Window window = dialog.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams params = window.getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.gravity = Gravity.BOTTOM;
                //设置弹出动画
                window.setWindowAnimations(R.style.main_menu_animStyle);
                window.setAttributes(params);

                dialog.show();
            }
        });

    }



}
