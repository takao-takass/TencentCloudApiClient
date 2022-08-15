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

            var secretId = args[0];
            var secretKey = args[0];

            Credential cred = new Credential("SecretId", "SecretKey");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tem.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            TemClient client = new TemClient(cred, "ap-tokyo", clientProfile);

            RollingUpdateApplicationByVersionRequest req = new RollingUpdateApplicationByVersionRequest();
            req.setApplicationId("application-ojb27d7j");
            req.setEnvironmentId("environment-l5mmvyy5");
            req.setDeployVersion("v20220812_1855");
            req.setDeployStrategyType("AUTO");
            req.setTotalBatchCount(1L);

            RollingUpdateApplicationByVersionResponse resp = client.RollingUpdateApplicationByVersion(req);

            System.out.println(RollingUpdateApplicationByVersionResponse.toJsonString(resp));

        } catch (TencentCloudSDKException e) {

            System.out.println(e.toString());

        }

    }
}