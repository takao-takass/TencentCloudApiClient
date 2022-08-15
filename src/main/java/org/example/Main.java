package org.example;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tem.v20210701.TemClient;
import com.tencentcloudapi.tem.v20210701.models.*;

public class Main {

    public static void main(String [] args) {

        try{

            // API Access
            var secretId = args[0];
            var secretKey = args[1];

            // Application
            var applicationId = args[2];
            var environmentId = args[3];
            var version = args[4];

            Credential cred = new Credential(secretId, secretKey);

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tem.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            TemClient client = new TemClient(cred, "ap-tokyo", clientProfile);

            RollingUpdateApplicationByVersionRequest req = new RollingUpdateApplicationByVersionRequest();
            req.setApplicationId(applicationId);
            req.setEnvironmentId(environmentId);
            req.setDeployVersion(version);
            req.setDeployStrategyType("AUTO");
            req.setTotalBatchCount(1L);

            RollingUpdateApplicationByVersionResponse resp = client.RollingUpdateApplicationByVersion(req);

            System.out.println(RollingUpdateApplicationByVersionResponse.toJsonString(resp));

        } catch (TencentCloudSDKException e) {

            System.out.println(e.toString());

        }

    }
}