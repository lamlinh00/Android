package www.g43.demob4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
//nhan dl va hien thi
    ImageView imageView;
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName= findViewById(R.id.tvName);
        imageView = findViewById(R.id.imgAvata);
        //tvName.setText(getIntent().getStringExtra("name"));// nhan dl truc tiep

        //nhan dl gian tiep qua bundle
        Bundle bundle = getIntent().getExtras();
        tvName.setText(bundle.getString("name"));
        //imageView.setImageURI(Uri.parse(bundle.getString("img")));
        imageView.setImageURI(Uri.parse(bundle.getString("img")));

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}