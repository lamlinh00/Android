package www.g43.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DemoTHB3 extends AppCompatActivity {

    ListView listView;
    ArrayList<Catagory> mListCategory;
    CategoryAdapter categoryAdapter;
    //demo BaseAdapter.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_thb3);

        listView = findViewById(R.id.listView);
        categoryAdapter= new CategoryAdapter(getListCategory(),this);
        listView.setAdapter(categoryAdapter);
    }
    private ArrayList<Catagory> getListCategory(){
        mListCategory = new ArrayList<>();
        mListCategory.add(new Catagory(R.drawable.aaaa,"AAAAACCCCVCCCCC","OJJJJJJJBBBBBB"));
        mListCategory.add(new Catagory(R.drawable.aaaa,"BAAAACCCCXCCCCC","LJJJJJJJBBBBBB"));
        mListCategory.add(new Catagory(R.drawable.aaaa,"CAAAACCCCDCCCCC","KJJJJJJJBBBBBB"));
        mListCategory.add(new Catagory(R.drawable.aaaa,"DAAAACCCCWCCCCC","JJJJJJJJBBBBBB"));
        mListCategory.add(new Catagory(R.drawable.aaaa,"EAAAACCCCFCCCCC","HJJJJJJJBBBBBB"));

        return mListCategory;
    }
}