package com.example.a31372.customlistdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView simpleList;
    private ArrayList<Item> animalList=new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);

        Initialize();

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Iist_view.class);
                intent.putExtra("AnimalName",animalList.get(position).getAnimalName());
                intent.putExtra("image",animalList.get(position).getAnimalImage());
                startActivity(intent);
            }
        });

        simpleList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("确定删除？");
                builder.setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        animalList.remove(position);
                        myAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                return false;
            }
        });
    }

    /*
    初始化列表
     */
    private void Initialize() {
        animalList.add(new Item("China",R.drawable.china));
        animalList.add(new Item("Finland",R.drawable.finland));
        animalList.add(new Item("France",R.drawable.france));
        animalList.add(new Item("Algeria",R.drawable.algeria));
        animalList.add(new Item("Chile",R.drawable.chile));
        animalList.add(new Item("Denmark",R.drawable.denmark));
        animalList.add(new Item("Ecuador",R.drawable.ecuador));
        animalList.add(new Item("Austria",R.drawable.austria));
        animalList.add(new Item("Dominica",R.drawable.dominica));
        animalList.add(new Item("Colombia",R.drawable.colombia));
        animalList.add(new Item("Afghanistan",R.drawable.afghanistan));
        animalList.add(new Item("Albania",R.drawable.albania));
        animalList.add(new Item("American_samoa",R.drawable.american_samoa));
        animalList.add(new Item("Andorra",R.drawable.andorra));
        animalList.add(new Item("Angola",R.drawable.angola));
        animalList.add(new Item("Anguilla",R.drawable.anguilla));
        animalList.add(new Item("Argentina",R.drawable.argentina));
        animalList.add(new Item("Armenia",R.drawable.armenia));
        animalList.add(new Item("Aruba",R.drawable.aruba));
        animalList.add(new Item("Costa_rica",R.drawable.costa_rica));
        animalList.add(new Item("Germany",R.drawable.germany));
        animalList.add(new Item("Japan",R.drawable.japan));
        myAdapter=new MyAdapter(this,R.layout.list_view_items,animalList);
        simpleList.setAdapter(myAdapter);
    }
}
