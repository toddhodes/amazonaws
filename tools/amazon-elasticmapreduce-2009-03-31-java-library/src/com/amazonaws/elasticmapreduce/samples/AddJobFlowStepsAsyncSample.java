/******************************************************************************* 
 *  Copyright 2008 Amazon Technologies, Inc.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *    __  _    _  ___ 
 *   (  )( \/\/ )/ __)
 *   /__\ \    / \__ \
 *  (_)(_) \/\/  (___/
 * 
 *  Amazon Elastic Map Reduce Java Library
 *  API Version: 2009-03-31
 *  Generated: Tue Apr 21 15:28:09 PDT 2009 
 * 
 */



package com.amazonaws.elasticmapreduce.samples;

import java.util.List;
import java.util.ArrayList;
import com.amazonaws.elasticmapreduce.*;
import com.amazonaws.elasticmapreduce.model.*;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * Add Job Flow Steps  Samples
 *
 *
 */
public class AddJobFlowStepsAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Add Job Flow Steps functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
        /************************************************************************
         * Access Key ID and Secret Acess Key ID, obtained from:
         * http://aws.amazon.com
         ***********************************************************************/
         String accessKeyId = "<Your Access Key ID>";
         String secretAccessKey = "<Your Secret Access Key>";

        /************************************************************************
         * Instantiate Http Client Implementation of Amazon Elastic Map Reduce 
         * 
         * Important! Number of threads in executor should match number of connections
         * for http client.
         *
         ***********************************************************************/

         AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig().withMaxConnections (100);
         ExecutorService executor = Executors.newFixedThreadPool(100);
         AmazonElasticMapReduceAsync service = new AmazonElasticMapReduceAsyncClient(accessKeyId, secretAccessKey, config, executor);

        /************************************************************************
         * Setup requests parameters and invoke parallel processing. Of course
         * in real world application, there will be much more than a couple of
         * requests to process.
         ***********************************************************************/
         AddJobFlowStepsRequest requestOne = new AddJobFlowStepsRequest();
         // @TODO: set request parameters here

         AddJobFlowStepsRequest requestTwo = new AddJobFlowStepsRequest();
         // @TODO: set second request parameters here

         List<AddJobFlowStepsRequest> requests = new ArrayList<AddJobFlowStepsRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeAddJobFlowSteps(service, requests);

         executor.shutdown();

    }


                
    /**
     * Add Job Flow Steps request sample
  
     * @param service instance of AmazonElasticMapReduce service
     * @param requests list of requests to process
     */
    public static void invokeAddJobFlowSteps(AmazonElasticMapReduceAsync service, List<AddJobFlowStepsRequest> requests) {
        List<Future<AddJobFlowStepsResponse>> responses = new ArrayList<Future<AddJobFlowStepsResponse>>();
        for (AddJobFlowStepsRequest request : requests) {
            responses.add(service.addJobFlowStepsAsync(request));
        }
        for (Future<AddJobFlowStepsResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                AddJobFlowStepsResponse response = future.get();
                // Original request corresponding to this response, if needed:
                AddJobFlowStepsRequest originalRequest = requests.get(responses.indexOf(future));
                System.out.println("Response request id: " + response.getResponseMetadata().getRequestId());
            } catch (Exception e) {
                if (e.getCause() instanceof AmazonElasticMapReduceException) {
                    AmazonElasticMapReduceException exception = AmazonElasticMapReduceException.class.cast(e.getCause());
                    System.out.println("Caught Exception: " + exception.getMessage());
                    System.out.println("Response Status Code: " + exception.getStatusCode());
                    System.out.println("Error Code: " + exception.getErrorCode());
                    System.out.println("Error Type: " + exception.getErrorType());
                    System.out.println("Request ID: " + exception.getRequestId());
                    System.out.print("XML: " + exception.getXML());
                } else {
                    e.printStackTrace();
                }
            }
        }
    }
                
}
