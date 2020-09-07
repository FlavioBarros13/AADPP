package com.mocedesenhos.aadpp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mocedesenhos.aadpp.Adapters.LearningLeadersAdapter;
import com.mocedesenhos.aadpp.Api.Api;
import com.mocedesenhos.aadpp.Api.ApiClient;
import com.mocedesenhos.aadpp.Interfaces.ItemClickListener;
import com.mocedesenhos.aadpp.Models.LearningLeadersModel;
import com.mocedesenhos.aadpp.Models.SkillsIQModel;
import com.mocedesenhos.aadpp.R;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment implements ItemClickListener {



    public LearningLeadersFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.LearningLeadersRecyclerView)
    RecyclerView LearningLeadersRecyclerView;

    LearningLeadersAdapter learningLeadersAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<LearningLeadersModel> homeProductModelList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        ButterKnife.bind(this,v);


        initRecyclerView();
        return v;
    }



    private void getLearningData()
    {
        Call<List<LearningLeadersModel>>getLearningLeaders= ApiClient.getAPi().LearningLeaderList();

        getLearningLeaders.enqueue(new Callback<List<LearningLeadersModel>>() {
            @Override
            public void onResponse(Call<List<LearningLeadersModel>> call, Response<List<LearningLeadersModel>> response) {

                if(response.isSuccessful())
                {
                    homeProductModelList=response.body();
                    learningLeadersAdapter =new LearningLeadersAdapter(getContext(),homeProductModelList);
                    System.out.println("POSITIVE"+response.message());
                    LearningLeadersRecyclerView.setAdapter(learningLeadersAdapter);
                    learningLeadersAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<LearningLeadersModel>> call, Throwable t) {

                Toast.makeText(getContext(), "Negative: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });




    }
    private void initRecyclerView()
    {
        //HomeSwipe_Refresh_Layout.setRefreshing(false);

        LearningLeadersRecyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        LearningLeadersRecyclerView.setLayoutManager(layoutManager);
        getLearningData();




    }

    @Override
    public void onClick(LearningLeadersModel model) {


    }

    @Override
    public void onClick(SkillsIQModel model) {

    }
}