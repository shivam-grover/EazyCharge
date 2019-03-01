package com.example.chargerapp1;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
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
    private static final int MODEL_COUNT = 4;
    private ArcProgressStackView mArcProgressStackView;
    
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LineChart chart = (LineChart) findViewById(R.id.charts);
        mArcProgressStackView = (ArcProgressStackView) findViewById(R.id.arcG);
        mArcProgressStackView.setIsShadowed(false);
//        mArcProgressStackView.setShadowColor(Color.argb(200, 0, 0, 0));
        mArcProgressStackView.setAnimationDuration(1000);
        mArcProgressStackView.setSweepAngle(270);

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


        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(0,0));
        entries.add(new Entry(1,5));
        entries.add(new Entry(2,7));
        entries.add(new Entry(3,9));
        entries.add(new Entry(4,2));
        entries.add(new Entry(5,6));
        entries.add(new Entry(6,8));
        entries.add(new Entry(7,3));
        entries.add(new Entry(8,6));
        entries.add(new Entry(9,3));
        entries.add(new Entry(10,2));
        entries.add(new Entry(11,4));
        entries.add(new Entry(12,5));
        entries.add(new Entry(13,5));
        entries.add(new Entry(14,7));
        entries.add(new Entry(15,8));
        entries.add(new Entry(16,4));
        entries.add(new Entry(17,4));
        entries.add(new Entry(18,7));
        entries.add(new Entry(19,5));
        entries.add(new Entry(20,7));
        entries.add(new Entry(21,9));
        entries.add(new Entry(22,4));
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
        Button button = findViewById(R.id.button);
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
//                graph.removeAllSeries();
////                series.resetData(new DataPoint[6]);
////                series.appendData(new DataPoint{new DataPoint(4,3)});
//                series.appendData(new DataPoint(24,5), false, 100, false);
//                series.appendData(new DataPoint(28,2), false, 100, true);
//
//                graph.addSeries(series);
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
