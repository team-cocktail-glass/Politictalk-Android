package politictalk.dsm.Meeting;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import politictalk.dsm.R;

public class MeetingMainAdapter extends RecyclerView.Adapter<MeetingMainAdapter.CostomViewHolder>{
    Context context;
    ArrayList<MeetingMainData> people;

    public MeetingMainAdapter(Context context, ArrayList<MeetingMainData> singModels) {
        this.context = context;
        this.people = singModels;
    }

    @Override
    public MeetingMainAdapter.CostomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meeting_main_itemview, parent, false);
        return new MeetingMainAdapter.CostomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingMainAdapter.CostomViewHolder holder, final int position) {
        holder.adress.setText(people.get(position).getAdress());
        holder.name.setText(people.get(position).getName());
        Glide.with(context).load(people.get(position).getImage()).into(holder.image);
//        holder.image.setImageResource(people.get(position).getImage());
        holder.contanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MeetingChoiceActivity.class);
                intent.putExtra("pId", people.get(position).getpId());
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
        ImageView image;
        ConstraintLayout contanier;

        public CostomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            adress = itemView.findViewById(R.id.day);
            image = itemView.findViewById(R.id.scenery);
            contanier = itemView.findViewById(R.id.meetingitem_container);
        }
    }
}
