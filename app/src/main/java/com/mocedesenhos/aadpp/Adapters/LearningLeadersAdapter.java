package com.mocedesenhos.aadpp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mocedesenhos.aadpp.Interfaces.ItemClickListener;
import com.mocedesenhos.aadpp.Models.LearningLeadersModel;
import com.mocedesenhos.aadpp.R;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private Context mContext;
    private ItemClickListener itemClickListener;
    private List<LearningLeadersModel> learningLeadersModelList;
    RequestOptions requestOptions ;


    public LearningLeadersAdapter(Context mContext, List<LearningLeadersModel> learningLeadersModelList) {
        this.mContext = mContext;
        this.learningLeadersModelList = learningLeadersModelList;
        requestOptions = new RequestOptions().fitCenter();
    }

    @NonNull
    @Override
    public LearningLeadersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_learning_leaders_layout,parent,false);

        return new LearningLeadersAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeadersAdapter.ViewHolder holder, int position) {


          holder.Custom_learning_leaders_name_layout        .setText(learningLeadersModelList.get(position).getName());
          holder.Custom_learning_leaders_hours_layout.setText(learningLeadersModelList.get(position).getHours() + " Learning hours, ");
          holder.Custom_learning_leaders_country_layout.setText(learningLeadersModelList.get(position).getCountry());
          Glide.with(mContext).load(learningLeadersModelList.get(position).getBadgeUrl()).into(holder.Custom_learning_leaders_image_layout);


    }

    @Override
    public int getItemCount() {
        return learningLeadersModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Custom_learning_leaders_image_layout;
        TextView Custom_learning_leaders_name_layout;
        TextView Custom_learning_leaders_country_layout;
        TextView Custom_learning_leaders_hours_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             Custom_learning_leaders_image_layout        =itemView.findViewById(R.id.Custom_learning_leaders_image_layout);
             Custom_learning_leaders_name_layout         =itemView.findViewById(R.id.Custom_learning_leaders_name_layout);
            Custom_learning_leaders_country_layout         =itemView.findViewById(R.id.Custom_learning_leaders_country_layout);
             Custom_learning_leaders_hours_layout =itemView.findViewById(R.id.Custom_learning_leaders_hours_layout);

             
        }
    }
}
