package com.mocedesenhos.aadpp.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mocedesenhos.aadpp.Adapters.LearningLeadersAdapter;
import com.mocedesenhos.aadpp.Adapters.SkillsIQAdapter;
import com.mocedesenhos.aadpp.Api.ApiClient;
import com.mocedesenhos.aadpp.Models.LearningLeadersModel;
import com.mocedesenhos.aadpp.Models.SkillsIQModel;
import com.mocedesenhos.aadpp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillsIQFragment extends Fragment {



    public SkillsIQFragment() {
        // Required empty public constructor
    }



    @BindView(R.id.SkillsIQRecyclerView)
    RecyclerView SkillsIQRecyclerView;

    SkillsIQAdapter skillsIQAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<SkillsIQModel> homeProductModelList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v= inflater.inflate(R.layout.fragment_skills_i_q, container, false);
        ButterKnife.bind(this,v);


        initRecyclerView();
         return v;
    }

    private void getLearningData()
    {

        ProgressDialog dialog =new ProgressDialog(getContext());
        dialog.setMessage("Loading");
        dialog.show();

        Call<List<SkillsIQModel>> getSkillIQList= ApiClient.getAPi().SkillIQList();

        getSkillIQList.enqueue(new Callback<List<SkillsIQModel>>() {
            @Override
            public void onResponse(Call<List<SkillsIQModel>> call, Response<List<SkillsIQModel>> response) {

                if(response.isSuccessful())
                {
                    dialog.dismiss();
                    homeProductModelList=response.body();
                    skillsIQAdapter =new SkillsIQAdapter(getContext(),homeProductModelList);
                    System.out.println("POSITIVE"+response.message());
                    SkillsIQRecyclerView.setAdapter(skillsIQAdapter);
                    skillsIQAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<SkillsIQModel>> call, Throwable t) {

                dialog.dismiss();
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });




    }
    private void initRecyclerView()
    {
        //HomeSwipe_Refresh_Layout.setRefreshing(false);

        SkillsIQRecyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        SkillsIQRecyclerView.setLayoutManager(layoutManager);
        getLearningData();




    }
}