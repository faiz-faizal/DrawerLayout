package com.example.faiz_faizal.drawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] sideDrawer;
    private ActionBarDrawerToggle drawerlistener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.drawer_list);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        sideDrawer = getResources().getStringArray(R.array.sideDrawer);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sideDrawer));
        listView.setOnItemClickListener(this);
        drawerlistener = new ActionBarDrawerToggle(this, drawerLayout,R.string.) );
        drawerLayout.setDrawerListener(drawerlistener);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, sideDrawer[position]+"was selected",Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    private void selectItem(int position) {

        listView.setItemChecked(position, true);
        setTitle(sideDrawer[position]);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

}
