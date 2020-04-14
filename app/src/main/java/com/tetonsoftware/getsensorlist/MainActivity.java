package com.tetonsoftware.getsensorlist;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
//import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get a reference to the sensormanager
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		if (sm != null) {
			List<Sensor> listSensor = sm.getSensorList(Sensor.TYPE_ALL);
			List<String> listSensorType = new ArrayList<String>();

			for (Sensor i : listSensor) {
				listSensorType.add(i.getName() + " Power-" + i.getPower()
						+ " Delay-" + i.getMinDelay());
			}

			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSensorType));
			getListView().setTextFilterEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
