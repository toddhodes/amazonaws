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



package com.amazonaws.elasticmapreduce;

import com.amazonaws.elasticmapreduce.model.*;



/**

 * 
 */
public interface  AmazonElasticMapReduce {
    

        
    /**
     * Add Job Flow Steps 
     *
  
     * @param request
     *          AddJobFlowSteps Action
     * @return
     *          AddJobFlowSteps Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public AddJobFlowStepsResponse addJobFlowSteps(AddJobFlowStepsRequest request) throws AmazonElasticMapReduceException;


        
    /**
     * Terminate Job Flows 
     *
  
     * @param request
     *          TerminateJobFlows Action
     * @return
     *          TerminateJobFlows Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public TerminateJobFlowsResponse terminateJobFlows(TerminateJobFlowsRequest request) throws AmazonElasticMapReduceException;


        
    /**
     * Describe Job Flows 
     *
  
     * @param request
     *          DescribeJobFlows Action
     * @return
     *          DescribeJobFlows Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public DescribeJobFlowsResponse describeJobFlows(DescribeJobFlowsRequest request) throws AmazonElasticMapReduceException;


        
    /**
     * Run Job Flow 
     *
  
     * @param request
     *          RunJobFlow Action
     * @return
     *          RunJobFlow Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public RunJobFlowResponse runJobFlow(RunJobFlowRequest request) throws AmazonElasticMapReduceException;



}