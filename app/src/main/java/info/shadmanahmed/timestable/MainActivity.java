package info.shadmanahmed.timestable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable (int timesTable){

        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int i = 0; i <= 10; i++){
            timesTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableListView.setAdapter(mArrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context mContext = this;

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView) findViewById(R.id.TimesTableListViewId);
        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                System.out.println(i);
                int min = 1;
                int timesTable;
                if(i < min) {
                    timesTable = min;
                    timesTableSeekBar.setProgress(min);
                }
                else {
                    timesTable = i;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);

    }
}
