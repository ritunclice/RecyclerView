package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    int[] images={
            R.drawable.afg,R.drawable.argen,R.drawable.bangla,R.drawable.canada,
            R.drawable.danmark,R.drawable.egypt,R.drawable.france,R.drawable.germany,R.drawable.hungary,
            R.drawable.india,R.drawable.japan,R.drawable.kenya,R.drawable.lebanon,R.drawable.malaysia,
            R.drawable.netherlands,R.drawable.oman,R.drawable.pakisthan,R.drawable.qater,R.drawable.russia,
            R.drawable.saudi,R.drawable.turkey,R.drawable.uae,R.drawable.vietnam,R.drawable.yemen,R.drawable.zimbabwe};

    MyAdapter myAdapter;
    String[] title,des;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.recyclerViewId);
        title=getResources().getStringArray(R.array.Country_names);
        des=getResources().getStringArray(R.array.Country_des);

        myAdapter=new MyAdapter(this,title,des,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}