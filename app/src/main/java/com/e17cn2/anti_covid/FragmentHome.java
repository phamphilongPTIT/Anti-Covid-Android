package com.e17cn2.anti_covid;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    private CombinedChart mChart;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mChart = (CombinedChart) view.findViewById(R.id.combinedChart);
        outChart();
        return view;
    }

    private void outChart(){

        int[] point = {1000,800,900,1200,700,600,1500};
        int[] point1 = {150,500,400,900,600,800,500};
        final List<String> semesterName = new ArrayList<>();
        semesterName.add("Thứ 2");
        semesterName.add("Thứ 3");
        semesterName.add("Thứ 4");
        semesterName.add("Thứ 5");
        semesterName.add("Thứ 6");
        semesterName.add("Thứ 7");
        semesterName.add("Chủ Nhật");

//        for (int i=0;i<list.size();i++)
//            for (int j=i+1;j<list.size();j++)
//                if (list.get(i).getSemester().getName().equals(list.get(j).getSemester().getName()))
//                    list.remove(j);
//
//        int d=-1;
//        for (StudentPointModel studentPointModel:list) {
//            d++;
//            semesterName.add(studentPointModel.getSemester().getName());
//            point[d]= (float) ((float) (studentPointModel.getAvg())/2.5);
//        }

        mChart.getDescription().setEnabled(false);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);
        mChart.setHighlightFullBarEnabled(false);
//        mChart.setOnChartValueSelectedListener(this);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0);
        xAxis.setGranularity(1);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return semesterName.get((int) value % semesterName.size());
            }
        });

        CombinedData data = new CombinedData();
        LineData lineDatas = new LineData();
        lineDatas.addDataSet((ILineDataSet) dataChart(Color.RED,point,semesterName.size()));
        lineDatas.addDataSet((ILineDataSet) dataChart2(Color.GREEN,point1,semesterName.size()));

        data.setData(lineDatas);

        xAxis.setAxisMaximum(data.getXMax() + 1);

        mChart.setData(data);
        mChart.invalidate();
    }

//    public void onValueSelected(Entry e, Highlight h) {
//        Toast.makeText(this, "Value: " + e.getY() + ", index: "
//                + h.getX()
//                + ", DataSet index: "
//                + h.getDataSetIndex(), Toast.LENGTH_SHORT).show();
//    }

    public void onNothingSelected() {

    }
    private static DataSet dataChart(int textColor, int [] data, int size) {

        LineData d = new LineData();



        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int index = 0; index <=size-1; index++) {
            entries.add(new Entry(index, data[index]));
        }

        LineDataSet set = new LineDataSet(entries, "Số ca mắc mới");
        set.setColor(textColor);
        set.setLineWidth(3);
        set.setCircleColor(textColor);
        set.setCircleRadius(5);
        set.setFillColor(textColor);
//        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10);
        set.setValueTextColor(textColor);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return set;
    }

    private static DataSet dataChart2(int textColor, int [] data, int size) {

        LineData d = new LineData();



        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int index = 0; index <=size-1; index++) {
            entries.add(new Entry(index, data[index]));
        }

        LineDataSet set = new LineDataSet(entries, "Số ca bệnh khỏi");
        set.setColor(textColor);
        set.setLineWidth(3);
        set.setCircleColor(textColor);
        set.setCircleRadius(5);
        set.setFillColor(textColor);
//        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10);
        set.setValueTextColor(textColor);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return set;
    }
}
