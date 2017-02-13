package ol.danil.timecontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChart pieChart = (PieChart) findViewById(R.id.idPieChart);

        pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("");
        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
//More options just check out the documentation!

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));


        PieDataSet dataset = new PieDataSet(entries, "minutes");
        dataset.setValueTextSize(20);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Work");
        labels.add("Rest");
        labels.add("Others");


        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.PASTEL_COLORS); //
        pieChart.setData(data);
        data.setDrawValues(true);
        pieChart.animateY(2000);

        pieChart.saveToGallery("/sd/mychart.jpg", 85); // 85 is the quality of the image



    }
}