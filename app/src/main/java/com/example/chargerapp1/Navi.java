package com.example.chargerapp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import devlight.io.library.ArcProgressStackView;
import lecho.lib.hellocharts.view.LineChartView;    //aa

public class Navi extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int Arr[];
    public List<Entry> entries;
    private static final int MODEL_COUNT = 4;
    private ArcProgressStackView mArcProgressStackView;
    DatabaseReference databaseReference, databaseReference2;
    private int a = 0;
    Button button, button2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        databaseReference = FirebaseDatabase.getInstance().getReference();
        LineChart chart = (LineChart) findViewById(R.id.charts);
        button2= findViewById(R.id.button);
        button = findViewById(R.id.button1);
        mArcProgressStackView = (ArcProgressStackView) findViewById(R.id.arcG);
        mArcProgressStackView.setIsShadowed(false);
//        mArcProgressStackView.setShadowColor(Color.argb(200, 0, 0, 0));
        mArcProgressStackView.setAnimationDuration(1000);
        mArcProgressStackView.setSweepAngle(270);

        databaseReference = FirebaseDatabase.getInstance().getReference("num_cars_pred").child("0");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("num_cars_pred").child("0");

        final String[] stringColors = getResources().getStringArray(R.array.devlight);
        final String[] stringBgColors = getResources().getStringArray(R.array.bg);

        final int[] colors = new int[MODEL_COUNT];
        final int[] bgColors = new int[MODEL_COUNT];
        for (int i = 0; i < MODEL_COUNT; i++) {
            colors[i] = Color.parseColor(stringColors[i]);
            bgColors[i] = Color.parseColor(stringBgColors[i]);
        }
        
        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("", 100, Color.TRANSPARENT, colors[3]));
        models.add(new ArcProgressStackView.Model("", 40, Color.TRANSPARENT, colors[0]));
        models.add(new ArcProgressStackView.Model("", 20, Color.TRANSPARENT, colors[1]));
        models.add(new ArcProgressStackView.Model("", 60, Color.TRANSPARENT, colors[2]));

        mArcProgressStackView.setModels(models);
        mArcProgressStackView.setSweepAngle(360);

        entries = new ArrayList<Entry>();

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                int i =0;
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    entries.add(new Entry(i,Integer.parseInt(snapshot.getValue().toString())));
//                    i++;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Log.i("SnapshotHEY!: ", String.valueOf(dataSnapshot.getChildren().));
////                    Toast.makeText(getApplicationContext(),Integer.parseInt(snapshot.getValue().toString()),Toast.LENGTH_SHORT).show();
//
////                            entries.add(new Entry(a,Integer.parseInt(snapshot.getValue().toString())));
//
////                       Arr[a] = Integer.parseInt(snapshot.getValue().toString());
////                    User user = snapshot.getValue(User.class);
////                    System.out.println(user.email);
//                }            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        Toast.makeText(this, String.valueOf(a),Toast.LENGTH_SHORT).show();
        entries.add(new Entry(0,6));
        entries.add(new Entry(1,11));
        entries.add(new Entry(2,4));
        entries.add(new Entry(3,8));
        entries.add(new Entry(4,9));
        entries.add(new Entry(5,9));
        entries.add(new Entry(6,12));
        entries.add(new Entry(7,3));
        entries.add(new Entry(8,14));
        entries.add(new Entry(9,7));
        entries.add(new Entry(10,18));
        entries.add(new Entry(11,5));
        entries.add(new Entry(12,14));
        entries.add(new Entry(13,3));
        entries.add(new Entry(14,5));
        entries.add(new Entry(15,3));
        entries.add(new Entry(16,14));
        entries.add(new Entry(17,14));
        entries.add(new Entry(18,5));
        entries.add(new Entry(19,10));
        entries.add(new Entry(20,14));
        entries.add(new Entry(21,15));
        entries.add(new Entry(22,16));
        entries.add(new Entry(23,5));

        LineDataSet dataSet = new LineDataSet(entries,"Nice");
        dataSet.setColor(Color.parseColor("#dd2471"));
        dataSet.setDrawCircles(false);
        dataSet.setFillDrawable(getDrawable(R.drawable.gradient));
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setDrawValues(false);
//        dataSet.setFillColor(Color.parseColor("#9099cc00"));
        dataSet.setDrawFilled(true);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.getAxisLeft().setTextColor(Color.WHITE);
        chart.getAxisRight().setTextColor(Color.WHITE);
        chart.getXAxis().setTextColor(Color.WHITE);
        chart.getLegend().setTextColor(Color.WHITE);
        chart.animateX(900);
        chart.animateY(1000);
        chart.setTouchEnabled(true);

        chart.animate();
        chart.invalidate();
//        final GraphView graph = findViewById(R.id.graph);
//
//        final LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0,2),
//                new DataPoint(2,5),
//                new DataPoint(4,3),
//                new DataPoint(6,2),
//                new DataPoint(8,2),
//            new DataPoint(10,5),
//            new DataPoint(12,3),
//            new DataPoint(14,2),
//                new DataPoint(16,2),
//                new DataPoint(18,5),
//                new DataPoint(20,4),
//                new DataPoint(22,3)
//        });
//        series.setColor(Color.parseColor("#9099cc00"));
//        series.setBackgroundColor(Color.parseColor("#8099cc00"));
//        series.setDrawBackground(true);
//        graph.addSeries(series);
//        graph.getViewport().setMaxX(24);
//        graph.getViewport().setXAxisBoundsManual(true);
//        graph.getGridLabelRenderer().setGridColor(Color.WHITE);
//        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
//        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
//        graph.getGridLabelRenderer().setPadding(20);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navi.this, PriceUpdate.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
