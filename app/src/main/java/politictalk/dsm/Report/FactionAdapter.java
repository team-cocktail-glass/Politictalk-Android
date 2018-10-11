package politictalk.dsm.Report;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
    public void onBindViewHolder(CostomViewHolder holder, final int position) {
        holder.adress.setText(people.get(position).getAdress());
        holder.date.setText(people.get(position).getDate());
        holder.firenum.setText(people.get(position).getFirenum() + "");
        holder.name.setText(people.get(position).getName());
        holder.peoplenum.setText(people.get(position).getPeoplenum() + "");

        Glide.with(context).load(people.get(position).getImage()).into(holder.image);
        holder.contanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReportActivity.class);
                intent.putExtra("pId", people.get(position).getpId());
                Log.d("Debug","AFADSFADSF : "+ people.get(position).getpId());
//                intent.putExtra();
                view.getContext().startActivity(intent);
            }
        });
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
        ConstraintLayout contanier;

        public CostomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            adress = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.scenery);
            peoplenum = itemView.findViewById(R.id.peopleNum);
            firenum = itemView.findViewById(R.id.firenumber);
            contanier = itemView.findViewById(R.id.factionItem_container);
        }
    }
}