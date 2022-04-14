package com.example.rcv_cities2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<City> citisList;
    private RecyclerView rcvCities;
private CitiesAdapter citiesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initui();
    }

    private void initui() {
        rcvCities = findViewById(R.id.rcvCities);
        citisList = new ArrayList<>();
        citisList.add(new City(R.drawable.amrav, "Amravati", "Maharashtra", 4000000L,"Amravati is a beautiful city loerem fkfkfjf jnsnjfsfn jnjsnsnc"));
        citisList.add(new City(R.drawable.dehli, "Dehli", "Dehli", 500000L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.mumbai, "Mumbai", "Maharashtra", 500050L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.nagpur, "NAgpur", "Maharashtra", 5563000L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.nanded, "Nanded", "Maharashtra", 504500L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img, "Yavatmal", "Maharashtra", 700000L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_1, "Pune", "Maharashtra", 50061400L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_2, "Hyderabad", "Hyderabad", 5621400L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.mumbai, "Mumbai", "Maharashtra", 500050L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.nagpur, "NAgpur", "Maharashtra", 5563000L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.nanded, "Nanded", "Maharashtra", 504500L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img, "Yavatmal", "Maharashtra", 700000L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_1, "Pune", "Maharashtra", 50061400L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_2, "Hyderabad", "Hyderabad", 5621400L,"Demo description demo of details"));
        citisList.add(new City(R.drawable.img_3, "Chennai", "Tamilnadu", 454555L,"Demo description demo of details"));
      /*  rcvCities.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,
                false));*/
        //grid layout
       /* rcvCities.setLayoutManager(
                new GridLayoutManager(this,3)
        );*/
        //staggered Grid
        rcvCities.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        citiesAdapter=new CitiesAdapter(citisList);
        citiesAdapter.setOnCityClickListener(new MyCityClickListener());

        rcvCities.setAdapter(citiesAdapter);


    }
class MyCityClickListener implements CitiesAdapter.OnCityClickListener{

    @Override
    public void onCityImageClick(ImageView imageView, City city, int position) {
        Toast.makeText(MainActivity.this, "Image :"+city.getImgID(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCityNameClickListener(TextView textView, City city, int positon) {
       textView.setTextColor(Color.RED);
        Toast.makeText(MainActivity.this, "Name:"+city.getName(), Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(MainActivity.this,CityDetailsActivity.class);
        intent.putExtra(City.KEY_CITY,city);
        startActivity(intent);
    }
}
}