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
import com.amazonaws.elasticmapreduce.mock.AmazonElasticMapReduceMock;

/**
 *
 * Describe Job Flows  Samples
 *
 *
 */
public class DescribeJobFlowsSample {

    /**
     * Just add few required parameters, and try the service
     * Describe Job Flows functionality
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
         ***********************************************************************/
        AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(accessKeyId, secretAccessKey);
        
        /************************************************************************
         * Uncomment to try advanced configuration options. Available options are:
         *
         *  - Signature Version
         *  - Proxy Host and Proxy Port
         *  - Service URL
         *  - User Agent String to be sent to Amazon Elastic Map Reduce   service
         *
         ***********************************************************************/
        // AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
        // config.setSignatureVersion("0");
        // AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(accessKeyId, secretAccessKey, config);
 
        /************************************************************************
         * Uncomment to try out Mock Service that simulates Amazon Elastic Map Reduce 
         * responses without calling Amazon Elastic Map Reduce  service.
         *
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         *
         * XML files available under com/amazonaws/elasticmapreduce/mock tree
         *
         ***********************************************************************/
        // AmazonElasticMapReduce service = new AmazonElasticMapReduceMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Describe Job Flows 
         ***********************************************************************/
         DescribeJobFlowsRequest request = new DescribeJobFlowsRequest();
        
         // @TODO: set request parameters here

         // invokeDescribeJobFlows(service, request);

    }


                        
    /**
     * Describe Job Flows  request sample
  
     * @param service instance of AmazonElasticMapReduce service
     * @param request Action to invoke
     */
    public static void invokeDescribeJobFlows(AmazonElasticMapReduce service, DescribeJobFlowsRequest request) {
        try {
            
            DescribeJobFlowsResponse response = service.describeJobFlows(request);

            
            System.out.println ("DescribeJobFlows Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    DescribeJobFlowsResponse");
            System.out.println();
            if (response.isSetDescribeJobFlowsResult()) {
                System.out.println("        DescribeJobFlowsResult");
                System.out.println();
                DescribeJobFlowsResult  describeJobFlowsResult = response.getDescribeJobFlowsResult();
                java.util.List<JobFlowDetail> jobFlowsList = describeJobFlowsResult.getJobFlows();
                for (JobFlowDetail jobFlows : jobFlowsList) {
                    System.out.println("            JobFlows");
                    System.out.println();
                    if (jobFlows.isSetJobFlowId()) {
                        System.out.println("                JobFlowId");
                        System.out.println();
                        System.out.println("                    " + jobFlows.getJobFlowId());
                        System.out.println();
                    }
                    if (jobFlows.isSetName()) {
                        System.out.println("                Name");
                        System.out.println();
                        System.out.println("                    " + jobFlows.getName());
                        System.out.println();
                    }
                    if (jobFlows.isSetLogUri()) {
                        System.out.println("                LogUri");
                        System.out.println();
                        System.out.println("                    " + jobFlows.getLogUri());
                        System.out.println();
                    }
                    if (jobFlows.isSetExecutionStatusDetail()) {
                        System.out.println("                ExecutionStatusDetail");
                        System.out.println();
                        JobFlowExecutionStatusDetail  executionStatusDetail = jobFlows.getExecutionStatusDetail();
                        if (executionStatusDetail.isSetState()) {
                            System.out.println("                    State");
                            System.out.println();
                            System.out.println("                        " + executionStatusDetail.getState());
                            System.out.println();
                        }
                        if (executionStatusDetail.isSetCreationDateTime()) {
                            System.out.println("                    CreationDateTime");
                            System.out.println();
                            System.out.println("                        " + executionStatusDetail.getCreationDateTime());
                            System.out.println();
                        }
                        if (executionStatusDetail.isSetStartDateTime()) {
                            System.out.println("                    StartDateTime");
                            System.out.println();
                            System.out.println("                        " + executionStatusDetail.getStartDateTime());
                            System.out.println();
                        }
                        if (executionStatusDetail.isSetEndDateTime()) {
                            System.out.println("                    EndDateTime");
                            System.out.println();
                            System.out.println("                        " + executionStatusDetail.getEndDateTime());
                            System.out.println();
                        }
                        if (executionStatusDetail.isSetLastStateChangeReason()) {
                            System.out.println("                    LastStateChangeReason");
                            System.out.println();
                            System.out.println("                        " + executionStatusDetail.getLastStateChangeReason());
                            System.out.println();
                        }
                    } 
                    if (jobFlows.isSetInstances()) {
                        System.out.println("                Instances");
                        System.out.println();
                        JobFlowInstancesDetail  instances = jobFlows.getInstances();
                        if (instances.isSetMasterInstanceType()) {
                            System.out.println("                    MasterInstanceType");
                            System.out.println();
                            System.out.println("                        " + instances.getMasterInstanceType());
                            System.out.println();
                        }
                        if (instances.isSetMasterPublicDnsName()) {
                            System.out.println("                    MasterPublicDnsName");
                            System.out.println();
                            System.out.println("                        " + instances.getMasterPublicDnsName());
                            System.out.println();
                        }
                        if (instances.isSetMasterInstanceId()) {
                            System.out.println("                    MasterInstanceId");
                            System.out.println();
                            System.out.println("                        " + instances.getMasterInstanceId());
                            System.out.println();
                        }
                        if (instances.isSetSlaveInstanceType()) {
                            System.out.println("                    SlaveInstanceType");
                            System.out.println();
                            System.out.println("                        " + instances.getSlaveInstanceType());
                            System.out.println();
                        }
                        if (instances.isSetInstanceCount()) {
                            System.out.println("                    InstanceCount");
                            System.out.println();
                            System.out.println("                        " + instances.getInstanceCount());
                            System.out.println();
                        }
                        if (instances.isSetEc2KeyName()) {
                            System.out.println("                    Ec2KeyName");
                            System.out.println();
                            System.out.println("                        " + instances.getEc2KeyName());
                            System.out.println();
                        }
                        if (instances.isSetPlacement()) {
                            System.out.println("                    Placement");
                            System.out.println();
                            PlacementType  placement = instances.getPlacement();
                            if (placement.isSetAvailabilityZone()) {
                                System.out.println("                        AvailabilityZone");
                                System.out.println();
                                System.out.println("                            " + placement.getAvailabilityZone());
                                System.out.println();
                            }
                        } 
                        if (instances.isSetKeepJobFlowAliveWhenNoSteps()) {
                            System.out.println("                    KeepJobFlowAliveWhenNoSteps");
                            System.out.println();
                            System.out.println("                        " + instances.isKeepJobFlowAliveWhenNoSteps());
                            System.out.println();
                        }
                    } 
                    java.util.List<StepDetail> stepsList = jobFlows.getSteps();
                    for (StepDetail steps : stepsList) {
                        System.out.println("                Steps");
                        System.out.println();
                        if (steps.isSetStepConfig()) {
                            System.out.println("                    StepConfig");
                            System.out.println();
                            StepConfig  stepConfig = steps.getStepConfig();
                            if (stepConfig.isSetName()) {
                                System.out.println("                        Name");
                                System.out.println();
                                System.out.println("                            " + stepConfig.getName());
                                System.out.println();
                            }
                            if (stepConfig.isSetActionOnFailure()) {
                                System.out.println("                        ActionOnFailure");
                                System.out.println();
                                System.out.println("                            " + stepConfig.getActionOnFailure());
                                System.out.println();
                            }
                            if (stepConfig.isSetHadoopJarStep()) {
                                System.out.println("                        HadoopJarStep");
                                System.out.println();
                                HadoopJarStepConfig  hadoopJarStep = stepConfig.getHadoopJarStep();
                                java.util.List<KeyValue> propertiesList = hadoopJarStep.getProperties();
                                for (KeyValue properties : propertiesList) {
                                    System.out.println("                            Properties");
                                    System.out.println();
                                    if (properties.isSetKey()) {
                                        System.out.println("                                Key");
                                        System.out.println();
                                        System.out.println("                                    " + properties.getKey());
                                        System.out.println();
                                    }
                                    if (properties.isSetValue()) {
                                        System.out.println("                                Value");
                                        System.out.println();
                                        System.out.println("                                    " + properties.getValue());
                                        System.out.println();
                                    }
                                }
                                if (hadoopJarStep.isSetJar()) {
                                    System.out.println("                            Jar");
                                    System.out.println();
                                    System.out.println("                                " + hadoopJarStep.getJar());
                                    System.out.println();
                                }
                                if (hadoopJarStep.isSetMainClass()) {
                                    System.out.println("                            MainClass");
                                    System.out.println();
                                    System.out.println("                                " + hadoopJarStep.getMainClass());
                                    System.out.println();
                                }
                                java.util.List<String> argsList  =  hadoopJarStep.getArgs();
                                for (String args : argsList) { 
                                    System.out.println("                            Args");
                                        System.out.println();
                                    System.out.println("                                " + args);
                                }	
                            } 
                        } 
                        if (steps.isSetExecutionStatusDetail()) {
                            System.out.println("                    ExecutionStatusDetail");
                            System.out.println();
                            StepExecutionStatusDetail  executionStatusDetail1 = steps.getExecutionStatusDetail();
                            if (executionStatusDetail1.isSetState()) {
                                System.out.println("                        State");
                                System.out.println();
                                System.out.println("                            " + executionStatusDetail1.getState());
                                System.out.println();
                            }
                            if (executionStatusDetail1.isSetCreationDateTime()) {
                                System.out.println("                        CreationDateTime");
                                System.out.println();
                                System.out.println("                            " + executionStatusDetail1.getCreationDateTime());
                                System.out.println();
                            }
                            if (executionStatusDetail1.isSetStartDateTime()) {
                                System.out.println("                        StartDateTime");
                                System.out.println();
                                System.out.println("                            " + executionStatusDetail1.getStartDateTime());
                                System.out.println();
                            }
                            if (executionStatusDetail1.isSetEndDateTime()) {
                                System.out.println("                        EndDateTime");
                                System.out.println();
                                System.out.println("                            " + executionStatusDetail1.getEndDateTime());
                                System.out.println();
                            }
                            if (executionStatusDetail1.isSetLastStateChangeReason()) {
                                System.out.println("                        LastStateChangeReason");
                                System.out.println();
                                System.out.println("                            " + executionStatusDetail1.getLastStateChangeReason());
                                System.out.println();
                            }
                        } 
                    }
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

           
        } catch (AmazonElasticMapReduceException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }
        
}
