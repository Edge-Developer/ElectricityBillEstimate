package edgedeveloper.electricitybillestimate.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edgedeveloper.electricitybillestimate.R;

/**
 * Created by OPEYEMI OLORUNLEKE on 1/7/2017.
 */

public class FeedAdapter extends ArrayAdapter<Post>{

    private int resource;
    private ArrayList<Post> dataSet;
    Context mContext;

    public FeedAdapter(ArrayList<Post> data, Context context) {
        super(context, R.layout.my_list, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private static class ViewHolder {
        TextView itemName;
        TextView power;
        TextView dailyHourUsage;
        TextView monthlyBill;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.my_list, parent, false);
            viewHolder.itemName = (TextView) convertView.findViewById(R.id.itemNAME);
            viewHolder.power = (TextView) convertView.findViewById(R.id.power);
            viewHolder.dailyHourUsage = (TextView) convertView.findViewById(R.id.usageDaily);
            viewHolder.monthlyBill = (TextView) convertView.findViewById(R.id.monthlyBill);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemName.setText(dataModel.getItemName());
        viewHolder.power.setText(dataModel.getPower());
        viewHolder.dailyHourUsage.setText(dataModel.getDailyUsage());
        viewHolder.monthlyBill.setText(dataModel.getMonthlyBill());

        return convertView;
    }
}
