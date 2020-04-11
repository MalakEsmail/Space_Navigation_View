package com.example.spacenavigationview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {
    SpaceNavigationView navigationView;
    TextView textView;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationView=findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_more_vert_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_home_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_message_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_notifications_black_24dp));
         textView=(TextView)findViewById(R.id.textView);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                navigationView.shouldShowFullBadgeText(true);
                navigationView.showBadgeAtIndex(3, count, Color.RED);



            }
        });


        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                count++;
                navigationView.shouldShowFullBadgeText(true);
                navigationView.showBadgeAtIndex(2, count, Color.RED);


            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
            }
        });


    }
}
