package politictalk.dsm.Report;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import politictalk.dsm.R;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.CostomViewHolder> {
    Context context;
    ArrayList<ReportData> people;

    public ReportAdapter(Context context, ArrayList<ReportData> politicsModels) {
        this.context = context;
        this.people = politicsModels;
    }

    @NonNull
    @Override
    public CostomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_itemview, parent, false);
        return new CostomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CostomViewHolder holder, int position) {
        holder.scenery.setImageResource(people.get(position).getScenery());
        holder.title.setText(people.get(position).getTitle());
        holder.day.setText(people.get(position).getDay());
        holder.name.setText(people.get(position).getName());
        holder.name.setText(people.get(position).getPeoplenum());
    }

    @Override
    public int getItemCount() { return people.size(); }

    class CostomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView title;
        TextView day;
        TextView peoplenum;
        ImageView scenery;

        public CostomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            day = itemView.findViewById(R.id.day);
            peoplenum = itemView.findViewById(R.id.peopleNum);
            scenery = itemView.findViewById(R.id.scenery);
        }
    }
}
