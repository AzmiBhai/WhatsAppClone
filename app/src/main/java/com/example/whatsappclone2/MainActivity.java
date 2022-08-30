package com.example.whatsappclone2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.whatsappclone2.ui.main.People;
import com.example.whatsappclone2.ui.main.PeopleAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.example.whatsappclone2.ui.main.SectionsPagerAdapter;
import com.example.whatsappclone2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<People> peoples;
    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        peoples = new ArrayList<>();

        peoples.add(new People("Person1","Hello","10:00 AM",5));
        peoples.add(new People("Person2","Hi","10:40 AM",10));
        peoples.add(new People("Person3","Hi","10:30 AM",1));
        peoples.add(new People("Person4","Hi","9:12 AM",5));
        peoples.add(new People("Person5","Hi","8:15 AM",7));
        peoples.add(new People("Person6","Hi","8:10 AM",2));
        peoples.add(new People("Person7","Hi","7:50 AM",12));
        peoples.add(new People("Person8","Hi","7:37 AM",4));
        peoples.add(new People("Person9","Hi","7:30 AM",2));
        peoples.add(new People("Person10","Hi","6:00 AM",0));
        peoples.add(new People("Person11","Hi","Yesterday",0));
        peoples.add(new People("Person12","Hi","Yesterday",0));
        peoples.add(new People("Person13","Hi","7/16/22",0));
        peoples.add(new People("Person14","Hi","7/13/22",0));
        peoples.add(new People("Person15","Hi","7/12/22",0));
        peoples.add(new People("Person16","Hi","7/12/22",0));
        peoples.add(new People("Person17","Hi","7/12/22",0));
        peoples.add(new People("Person18","Hi","7/9/22",0));
        peoples.add(new People("Person19","Hi","7/9/22",0));
        peoples.add(new People("Person20","Hi","7/7/22",0));
        peoples.add(new People("Person21","Hi","7/5/22",0));


        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),peoples);
        viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = binding.fab;


        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.optionmenu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id){
//            case R.id.settingmenu:
//                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
//                startActivity(intent);
//                finish();
//                return true;
//
//            case R.id.labelmenue:
//                Intent intent1 = new Intent(getApplicationContext(),LabelsActivity.class);
//                startActivity(intent1);
//                finish();
//            case R.id.linkedDevicesMenu:
//                Intent intent2 = new Intent(getApplicationContext(),LinkedDevicesActivity.class);
//                startActivity(intent2);
//                finish();
//            case R.id.newGroupMenu:
//                Intent intent3 = new Intent(getApplicationContext(),NewGroupActitvity.class);
//                startActivity(intent3);
//                finish();
//            case R.id.newBroadcastMenu:
//                Intent intent4 = new Intent(getApplicationContext(),NewBroadcastActivity.class);
//                startActivity(intent4);
//                finish();
//            case R.id.starredMessagesMenu:
//                Intent intent5 = new Intent(getApplicationContext(),StarredMessageActivity.class);
//                startActivity(intent5);
//                finish();
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}