package www.g43.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;// chuyen dl tu mang len man hinh
    ArrayList<String> listString;// demo ArrayAdapter. demo nay dang la tam thoi. luu dai han se dung csdl se hoc sau.
    ArrayAdapter<String> arrayAdapter; // t bat dau laf dai dien cho kieu dl

    EditText edtString;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView= findViewById(R.id.listView);
        listString = new ArrayList<>();
        listString.add("chuong 1");
        listString.add("chuong 2");
        listString.add("chuong 3");
        listString.add("chuong 4");

        edtString = findViewById(R.id.edtString);
        btnAdd = findViewById(R.id.btnAdd);

        arrayAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listString);// goi bo chuyen hien thi dl dang mang co san.
        listView.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item= edtString.getText().toString().trim();
                listString.add(item);
                arrayAdapter.notifyDataSetChanged();//khi co thay doi thi no se set ld do len cho mk
            }
        });
    }
}























