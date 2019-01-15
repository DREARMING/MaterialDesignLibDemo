package com.mvcoder.materialdesignlibdemo.coordinarylayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mvcoder.materialdesignlibdemo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinaryLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private CommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinary_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        setSupportActionBar(toolbar);

        List<String> itemList = new ArrayList<>();
        for(int i = 0 ; i < 20; i++) {
            itemList.add("item " + i);
        }
        if(adapter == null) {
            adapter = new CommonAdapter<String>(this, android.R.layout.simple_list_item_1, itemList) {
                @Override
                protected void convert(ViewHolder holder, String s, int position) {
                    holder.setText(android.R.id.text1, s);
                }
            };
        }
        recyclerView.setAdapter(adapter);
    }
}
