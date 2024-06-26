package com.multivariate.service;

import com.google.gson.JsonObject;

import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.dto.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CfClient cfClient;


    public JsonObject getFFJsonValue(String userEmail){
        return ffJsonVariation(userEmail);
    }
    public String getFFStringValue(String userEmail){
        return this.ffStringVariation(userEmail);
    }
    public double getFFNumberValue(String userEmail){
        return this.ffNumberVariation(userEmail);
    }
    public boolean getFFBooleanValue(String userEmail){
        return this.ffBooleanVariation(userEmail);
    }

    private Target harnessFFProvider(String userEmail){
        return Target.builder().name(userEmail)
                .identifier(userEmail)
                .build();
    }

    private String ffStringVariation(String userEmail){
        return cfClient.stringVariation("multivariance", harnessFFProvider(userEmail), "");
    }

    private JsonObject ffJsonVariation(String userEmail){
        return cfClient.jsonVariation("MultiFFJson", harnessFFProvider(userEmail), new JsonObject());
    }

    private double ffNumberVariation(String userEmail){
        return cfClient.numberVariation("Multivariate_Number", harnessFFProvider(userEmail), 0);
    }

    private boolean ffBooleanVariation(String userEmail){
        return cfClient.boolVariation("percentage_rollout", harnessFFProvider(userEmail), false);
    }
}
