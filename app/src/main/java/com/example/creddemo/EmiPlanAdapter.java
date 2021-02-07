package com.example.creddemo;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import net.igenius.customcheckbox.CustomCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Litesh Sinha on 6/22/17.
 */

public class EmiPlanAdapter extends RecyclerView.Adapter<EmiPlanAdapter.MyViewHolder> {
    Activity mcontext;
    String[] bgColors = {"#44353D", "#7B7390", "#586987"};
    String[] textColors = {"#615059", "#443e54", "#414d63"};
    String[] cbColors = {"#30242b", "#443e54", "#303a4d"};



    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb_plan)
        CustomCheckBox cbPlan;
        @BindView(R.id.tv_emi_amount)
        TextView tvEmiAmount;
        @BindView(R.id.tv_emi_duration)
        TextView tvEmiDuration;
        @BindView(R.id.tv_emi_description)
        TextView tvEmiDescription;
        @BindView(R.id.tv_emi_calculation)
        TextView tvEmiCalculation;
        @BindView(R.id.card_reco)
        CardView cardReco;
        @BindView(R.id.bg)
        CardView bg;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public EmiPlanAdapter(Activity mactivity) {

        this.mcontext = mactivity;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_emi_plans, parent, false);


        itemView.setMinimumHeight(itemView.getWidth() + 40);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.bg.setCardBackgroundColor(Color.parseColor(bgColors[position]));
        holder.cbPlan.setUnCheckedColor(Color.parseColor(cbColors[position]));
        holder.tvEmiDuration.setTextColor(Color.parseColor(textColors[position]));
        holder.tvEmiCalculation.setTextColor(Color.parseColor(textColors[position]));
        holder.tvEmiDescription.setTextColor(Color.parseColor(textColors[position]));

        if(position==1)
        {
            holder.cardReco.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}