package tech.rtsproduction.weather2go.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tech.rtsproduction.weather2go.R;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private final ItemClickListener mItemClickListener;
    //public WeatherData mWeatherData[];

    public ForecastAdapter(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
/*
    public void setmWeatherData(WeatherData[] mWeatherData) {
        this.mWeatherData = mWeatherData;
    }

    public void clearData(){
        this.mWeatherData = null;
        notifyDataSetChanged();
    }

    public WeatherData getmWeatherData(int position) {
        return mWeatherData[position];
    }
*/
    public interface  ItemClickListener{
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_listitem,viewGroup,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder forecastViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView day,temperature;
        ImageView tempIcon;

        public ForecastViewHolder(View itemView){
            super(itemView);
            day = itemView.findViewById(R.id.tv_listitem_day);
            temperature = itemView.findViewById(R.id.tv_listitem_temperature);
            tempIcon = itemView.findViewById(R.id.iv_listitem_weatherimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
/*
        public void bind(WeatherData data){
            day.setText(data.getDay());
            temperature.setText(data.getTempHL());
            tempIcon.setImageDrawable(data.getIcon());
        }

        */
    }
}
