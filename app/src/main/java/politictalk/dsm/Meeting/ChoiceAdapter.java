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

import java.util.ArrayList;

import politictalk.dsm.R;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.CostomViewHolder> {
    Context context;
    ArrayList<ChoiceData> people;

    public ChoiceAdapter(Context context, ArrayList<ChoiceData> data) {
        this.context = context;
        this.people = data;
    }

    public CostomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meeting_itemview, parent, false);
        return new CostomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CostomViewHolder holder, int position) {
        holder.image.setImageResource(people.get(position).getImage());
        holder.title.setText(people.get(position).getTitle());
        holder.name.setText(people.get(position).getName());
        holder.d_day.setText(people.get(position).getD_day());
        holder.peoplenum.setText(String.valueOf(people.get(position).getPeopleNumber()));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewMeetingActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class CostomViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView name;
        TextView d_day;
        TextView peoplenum;
        ConstraintLayout container;

        public CostomViewHolder(View itemview) {
            super(itemview);
            image = itemview.findViewById(R.id.scenery);
            title = itemview.findViewById(R.id.title);
            name = itemview.findViewById(R.id.name);
            d_day = itemview.findViewById(R.id.day);
            peoplenum = itemview.findViewById(R.id.peopleNumber);
            container = itemview.findViewById(R.id.memo_itemview);
        }
    }
}