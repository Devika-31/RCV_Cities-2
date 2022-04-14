package com.example.rcv_cities2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {
    private ArrayList<City> cityList;


    public CitiesAdapter(ArrayList cityList) {
        this.cityList = cityList;
    }

    public interface OnCityClickListener {
        void onCityImageClick(ImageView imageView, City city, int position);

        void onCityNameClickListener(TextView textView, City city, int positon);

    }

    private OnCityClickListener onCityClickListener;

    public void setOnCityClickListener(OnCityClickListener
                                               onCityClickListener) {

        this.onCityClickListener = onCityClickListener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.
                from(parent.getContext());
        //view is ref to container layout
        View view = layoutInflater.
                inflate(R.layout.cities_item_view,
                        null);
//not usefull because we didn't get position here
        /*view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(parent.getContext(), "View clicked", Toast.LENGTH_SHORT).show();
    }
});*/

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, @SuppressLint("RecyclerView") int position) {
        City city = cityList.get(position);
        Random random= new Random();
        holder.itemView.setBackgroundColor(Color.rgb(Math.abs(random.nextInt()%256),
                Math.abs(random.nextInt()%256),
                Math.abs(random.nextInt()%256)));
        holder.imgCity.setImageResource(city.getImgID());
        holder.tvname.setText(city.getName());
       /* holder.tvstate.setText(city.getState());
        holder.tvpopulation.setText("" + city.getPopulation());*/
        holder.tvDesc.setText(city.getDesc());
        //cpu uses will increase so not recommended
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        cityList.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        if (cityList == null)
            return 0;
        return cityList.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgCity;
        public TextView tvname, tvstate;
        public TextView tvpopulation,tvDesc;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCity = itemView.findViewById(R.id.ivCity);
            tvname = itemView.findViewById(R.id.tvNAme);
            tvstate = itemView.findViewById(R.id.tvState);
            tvpopulation = itemView.findViewById(R.id.tvPopulation);
            tvDesc=itemView.findViewById(R.id.tvDesc);
            imgCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onCityClickListener != null) {
                        onCityClickListener.onCityImageClick(
                                imgCity, cityList.get(getAdapterPosition()), getAdapterPosition()
                        );


                    }
               /*Toast.makeText(view.getContext(),"Image:"+ cityList.
                               get(
                       getAdapterPosition()).getName(),
                       Toast.LENGTH_SHORT).show();*/
                }
            });
            tvname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onCityClickListener!=null)
                    {
                        onCityClickListener.onCityNameClickListener(
                                tvname,cityList.get(getAdapterPosition()),getAdapterPosition()
                        );
                    }
                }
                    /*Toast.makeText(view.getContext(), "Name:" +
                            cityList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }*/
            });
            tvpopulation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Population: " + cityList
                            .get(getAdapterPosition()).getPopulation(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), CityDetailsActivity.class);
                    intent.putExtra(City.KEY_CITY, cityList.get(getAdapterPosition()));
                    view.getContext().startActivity(intent);
                }

            });

        }
    }


}
