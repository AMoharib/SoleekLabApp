package com.amoharib.soleeklabapp.ui.home;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.amoharib.soleeklabapp.R;
import com.amoharib.soleeklabapp.app.data.Country;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private List<Country> countries = new ArrayList<>();
    private Activity activity;

    public CountriesAdapter(Activity activity){
        this.activity = activity;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Country country = countries.get(i);
        viewHolder.updateUI(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.flag)
        ImageView flag;

        @BindView(R.id.country_name)
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void updateUI(Country country) {
            System.out.println("##" + country.getFlag());
            SvgLoader.pluck().with(activity).load(country.getFlag(), flag);
//            Glide.with(itemView).load(country.getFlag()).into(flag);
//            Picasso.get().load(country.getFlag()).into(flag);
            name.setText(country.getName());
        }
    }
}
