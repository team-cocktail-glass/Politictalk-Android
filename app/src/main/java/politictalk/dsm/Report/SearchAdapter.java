package politictalk.dsm.Report;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import politictalk.dsm.R;

public class SearchAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;
    String region;

    public SearchAdapter(List<String> list, Activity activity) {
        this.list = list;
        this.activity = activity;
        this.inflate = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null) {
            convertView = inflate.inflate(R.layout.row_listview, null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.label);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(activity, "Good", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("location", list.get(position));
                    activity.setResult(Activity.RESULT_OK, intent);
                    activity.finish();
//                    view.getContext().startActivity();
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.label.setText(list.get(position));

        return convertView;
    }

    class ViewHolder {
        public TextView label;
    }

//    public void get() {
//        Api retrofit = ServiceGenerator.getClient().create(Api.class);
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("region", region);
//        Call<Void> call=retrofit.get_politician(jsonObject);
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if(response.code() == 200) {
//                    Toast.makeText(activity, "조회 성공", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    Toast.makeText(activity, "조회 실패", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//
//            }
//        });
//    }
}
