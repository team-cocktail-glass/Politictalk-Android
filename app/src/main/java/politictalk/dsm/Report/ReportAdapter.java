package politictalk.dsm.Report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import politictalk.dsm.R;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.CostomViewHolder> {
    Context context;
    ArrayList<ReportData> people;

    public ReportAdapter(Context context, ArrayList<ReportData> singModels) {
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
        holder.date.setText(people.get(position).getDate());
        holder.name.setText(people.get(position).getName());
        holder.peoplenum.setText(people.get(position).getPeoplenum() + "");
        holder.image.setImageResource(people.get(position).getImage());
//        holder.image.set
        holder.title.setText(people.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class CostomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView title;
        TextView peoplenum;
        TextView date;
        ImageView image;

        public CostomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.UserProfile);
            peoplenum = itemView.findViewById(R.id.peoplenumber);
        }
    }
}