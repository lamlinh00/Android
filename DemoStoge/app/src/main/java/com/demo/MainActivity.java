package com.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "Store.db";
    private static final int DATABASE_VERSION = 1;
    ListView listView;
    ArrayList<Category> mListCaregory;
    CategoryAdapter categoryAdapter;
    DBHelper dbHelper = new DBHelper(MainActivity.this,DATABASE_NAME,null,DATABASE_VERSION);

    FloatingActionButton btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);
        btnadd = findViewById(R.id.btnInsert);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,InputActivity.class);
                startActivity(intent);
            }
        });
//        categoryAdapter = new CategoryAdapter(getListCategory(), this, new IClickItemListener() {
//            @Override
//            public void onClickItem(Category category) {
//                onClickGoToDetail(category);
//            }
//
//            private void onClickGoToDetail(Category category) {
//                Intent intent = new Intent(MainActivity.this,DetallActivity.class);
//                Bundle bundle = new Bundle();
//                // c1 bundle.putSerializable("abc", (Serializable) category); //ep kieu
//                bundle.putSerializable("abc",category);// c2. impliment sau ko can phai ep kieu lai nua
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });

        categoryAdapter = new CategoryAdapter(getListCategory(), this);
        listView.setAdapter(categoryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category= (Category) listView.getItemAtPosition(position);
                category.setID(position);
                onClickGoToDetail(category);
            }
        });

    }
    private void onClickGoToDetail(Category category) {
         Intent intent = new Intent(MainActivity.this,DetallActivity.class);
         Bundle bundle = new Bundle();
         // c1 bundle.putSerializable("abc", (Serializable) category); //ep kieu
         bundle.putSerializable("abc",category);// c2. impliment sau ko can phai ep kieu lai nua
         intent.putExtras(bundle);
         startActivity(intent);
    }
//    private ArrayList<Category> getListCategory(){
//
//
////        mListCaregory = new ArrayList<>();
////        mListCaregory.add(new Category(R.drawable.iis,"All In Love", "Co Tay Cuoc"));
////        mListCaregory.add(new Category(R.drawable.iis,"All In Love", "ABCDEFGHIK"));
////        mListCaregory.add(new Category(R.drawable.iis,"All In Love", "Hoa vang"));
////        mListCaregory.add(new Category(R.drawable.iis,"All In Love", "Tay Son"));
////        mListCaregory.add(new Category(R.drawable.iis,"All In Love", "Truyen Ky"));
//
//        return mListCaregory;
//    }

    private ArrayList<Category> getListCategory(){
        ArrayList<Category> mListCategory = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        //cursor duyet dl, la tap hop ket qua truy van. no duyet tung hang de thuc thi cac tac vu phuc tap
        Cursor cursor= sqLiteDatabase.rawQuery("Select * from Categories", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int ID = cursor.getInt(0);
            byte[] icon = cursor.getBlob(1);
            String title = cursor.getString(2);
            String author = cursor.getString(3);
            Category category = new Category(ID, icon,title,author);
            cursor.moveToNext();
            mListCategory.add(category);
        }
        cursor.close();
        sqLiteDatabase.close();
        return mListCategory;
    }
}