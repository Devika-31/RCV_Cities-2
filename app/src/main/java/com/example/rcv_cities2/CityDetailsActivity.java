package com.example.rcv_cities2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityDetailsActivity extends AppCompatActivity {
private City city;
private ImageView imgCityView;
private TextView tvName,tvPopulation,tvState;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        city= (City) getIntent().getSerializableExtra(City.KEY_CITY);
        setContentView(R.layout.city_details_activity);
        initUI();
        bindDataToView();

    }

    private void bindDataToView() {
        imgCityView.setImageResource(city.getImgID());
        tvName.setText(city.getName());
        tvState.setText(city.getState());
        tvPopulation.setText(""+city.getPopulation());
        
    }

    private void initUI() {
        imgCityView=findViewById(R.id.ivCityd);
        tvName=findViewById(R.id.tvNAmed);
        tvState=findViewById(R.id.tvStated);
        tvPopulation=findViewById(R.id.tvPopulationd);
    }
}
