package com.adafruit.bluefruit.le.connect.app;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.adafruit.bluefruit.le.connect.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigatorFragment extends Fragment implements SensorEventListener{

    private ImageView image;
    private float currentDegree;
    private SensorManager sensorManager;

    public NavigatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigator, container, false);
        image = (ImageView)view.findViewById(R.id.pointer);
        sensorManager = (SensorManager)this.getActivity().getSystemService(getActivity().SENSOR_SERVICE);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this
                ,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
                ,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);

        Log.d("Heading: ",""+ Float.toString(degree)+" degrees");

        RotateAnimation ra = new RotateAnimation(currentDegree
                ,-degree
                , Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,0.5f);

        ra.setDuration(500);

        ra.setFillAfter(true);

        image.startAnimation(ra);
        currentDegree = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
