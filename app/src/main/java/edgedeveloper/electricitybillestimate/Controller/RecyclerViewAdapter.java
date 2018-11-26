package edgedeveloper.electricitybillestimate.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edgedeveloper.electricitybillestimate.R;

/**
 * Created by OPEYEMI OLORUNLEKE on 1/26/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static ArrayList<Float> mymonthlyBills = new ArrayList<>();
    public Context mContext;
    private ArrayList<Post> mPosts;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        mPosts = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list, parent, false);
        return new ViewHolder(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) throws NullPointerException {
        Post post;

        if (mPosts == null) {
            Toast.makeText(mContext, "Now Empty!", Toast.LENGTH_SHORT).show();
        } else {
            post = mPosts.get(position);

            holder.monthlybill.setText(post.getMonthlyBill());
            holder.item.setText(post.getItemName());
            holder.usage.setText(post.getDailyUsage());
            holder.power.setText(post.getPower());
            holder.butn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeEntry(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void addEntry(Post entry) {
        mPosts.add(entry);
        notifyItemInserted(mPosts.size() - 1);
    }

    public void removeEntry(int position) {
        Toast.makeText(mContext, "Passed= "+position/*+" Removed= "+(position-1)*/, Toast.LENGTH_SHORT).show();
        try {
            if (position == 0){
                mPosts.remove(position);
            }else {
                mPosts.remove(position - 1);
            }
            mymonthlyBills.remove(position);
            notifyItemRemoved(position);
        }catch (Exception e){
            Toast.makeText(mContext, ""+e, Toast.LENGTH_LONG).show();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item, power, usage, monthlybill;
        private ImageView butn;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.itemNAME);
            power = (TextView) itemView.findViewById(R.id.power);
            usage = (TextView) itemView.findViewById(R.id.usageDaily);
            monthlybill = (TextView) itemView.findViewById(R.id.monthlyBill);
            butn = (ImageView) itemView.findViewById(R.id.myRemoveButton);
        }
    }
}