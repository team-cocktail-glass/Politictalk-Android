package politictalk.dsm.Report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import politictalk.dsm.R;

public class Adapter extends RecyclerView.Adapter<Adapter.CostomViewHolder> {
    Context context;
    ArrayList<Data> people;

    public Adapter(Context context, ArrayList<Data> singModels) {
        this.context = context;
        this.people = singModels;
    }

    @Override
    public CostomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.report_itmeview, parent, false);
        return new CostomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CostomViewHolder holder, int position) {
        holder.adress.setText(people.get(position).getAdress());
        holder.date.setText(people.get(position).getDate());
        Log.e("xxx", holder.firenum.toString());
        holder.firenum.setText(people.get(position).getFirenum() + "");
        holder.name.setText(people.get(position).getName());
        holder.peoplenum.setText(people.get(position).getPeoplenum() + "");
//        holder.image.setImageDrawable(people.get(position).getImage());
        holder.image.setImageResource(people.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class CostomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView adress;
        TextView firenum;
        TextView peoplenum;
        TextView date;
        ImageView image;

        public CostomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            adress = itemView.findViewById(R.id.adress);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.Profile);
            peoplenum = itemView.findViewById(R.id.peoplenumber);
            firenum = itemView.findViewById(R.id.firenumber);
        }
    }
}