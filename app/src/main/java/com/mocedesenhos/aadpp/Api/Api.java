package com.mocedesenhos.aadpp.Api;

import com.mocedesenhos.aadpp.Models.LearningLeadersModel;
import com.mocedesenhos.aadpp.Models.SkillsIQModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("hours")
    Call<List<LearningLeadersModel>>LearningLeaderList();

    @GET("skilliq")
    Call<List<SkillsIQModel>>SkillIQList();
}
