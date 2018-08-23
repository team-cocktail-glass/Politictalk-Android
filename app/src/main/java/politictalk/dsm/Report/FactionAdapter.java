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

public class FactionAdapter extends RecyclerView.Adapter<FactionAdapter.CostomViewHolder> {
    Context context;
    ArrayList<FactionData> people;

    public FactionAdapter(Context context, ArrayList<FactionData> singModels) {
        this.context = context;
        this.people = singModels;
    }

    @Override
    public CostomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faction_itemview, parent, false);
        return new CostomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CostomViewHolder holder, int position) {
        holder.adress.setText(people.get(position).getAdress());
        holder.date.setText(people.get(position).getDate());
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
            name = itemView.findViewById(R.id.title);
            adress = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.scenery);
            peoplenum = itemView.findViewById(R.id.peopleNum);
            firenum = itemView.findViewById(R.id.firenumber);
        }
    }
}