package com.example.zrd.myweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zrd.app.MyApplication;

import java.util.List;

public class SelectCity extends Activity {
    private ImageView mBackBtn;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        mListView=(ListView)findViewById(R.id.list_view);
        MyApplication my = (MyApplication) getApplication();//返回Application对象
        final List dataname =  my.getCityName();
        final List datacode = my.getCityCode();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                SelectCity.this,android.R.layout.simple_list_item_1,dataname);
        mListView.setAdapter(adapter);
        mBackBtn=(ImageView)findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * -->111110000
                 * "datacode.get(i)"
                 * */
                SelectCity.this.finish();//结束这个界面
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView,View view,int i,long I)  {
                Toast.makeText(SelectCity.this,"你选择的城市是："+dataname.get(i), Toast.LENGTH_SHORT).show();
                        Intent x = new Intent();
                        x.putExtra("cityCode", String.valueOf(datacode.get(i)));
                        setResult(RESULT_OK, x);
                        finish();
            }
        });
    }

//    @Override
////    public void onClick(View v){
////        switch (v.getId()){
////            case R.id.title_back:
////                Intent i=new Intent();
////                i.putExtra("cityCode","101160102");
////                Log.d("myWeather","mengmeng:"+i.getStringExtra("cityCode"));
////                setResult(RESULT_OK, i);
////                finish();
////                break;
////            default:
////                break;
////        }
////    }
}
