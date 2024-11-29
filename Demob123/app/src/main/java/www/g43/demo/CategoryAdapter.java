package www.g43.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    ArrayList<Catagory> mListCatagory;
    Context context;
    public CategoryAdapter(ArrayList<Catagory> mListCatagory,Context context){
        this.mListCatagory = mListCatagory;
        this.context= context;
    }

    @Override
    public int getCount() {
        return mListCatagory.size();
    }

    @Override
    public Object getItem(int position) {
        return mListCatagory.get(position);
    }// tra ve vi tri d.tg trong view. i=position.

    @Override
    public long getItemId(int id) {
        return 0;
    }// id

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category,viewGroup,false);
        //layout mk tu setup. khi mk sd trung gian thi attachToRoot de true

        Catagory catagory =mListCatagory.get(position);
        ImageView imgIcon = view.findViewById(R.id.imgIcon);
        TextView tvTitle = view.findViewById(R.id.tvTilte);
        TextView tvAuthor = view.findViewById(R.id.tvAuthor);

        imgIcon.setImageResource(catagory.getIcon());
        tvTitle.setText(catagory.getTitle());
        tvAuthor.setText(catagory.getAuthor());
        return view;
    }
}
