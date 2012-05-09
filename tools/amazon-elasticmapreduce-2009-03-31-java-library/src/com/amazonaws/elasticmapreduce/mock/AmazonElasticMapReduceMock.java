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



package com.amazonaws.elasticmapreduce.mock;

import com.amazonaws.elasticmapreduce.model.*;
import com.amazonaws.elasticmapreduce.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;

/**
 *
 * AmazonElasticMapReduceMock is the implementation of AmazonElasticMapReduce based
 * on the pre-populated set of XML files that serve local data. It simulates
 * responses from Amazon Elastic Map Reduce service.
 *
 * Use this to test your application without making a call to Amazon Elastic Map Reduce 
 *
 * Note, current Mock Service implementation does not valiadate requests
 *
 */
public  class AmazonElasticMapReduceMock implements AmazonElasticMapReduce {

    private final Log log = LogFactory.getLog(AmazonElasticMapReduceMock.class);
    private static JAXBContext  jaxbContext;
    private static ThreadLocal<Unmarshaller> unmarshaller;


    /** Initialize JAXBContext and  Unmarshaller **/
    static {
        try {
            jaxbContext = JAXBContext.newInstance("com.amazonaws.elasticmapreduce.model", AmazonElasticMapReduce.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            protected synchronized Unmarshaller initialValue() {
                try {
                    return jaxbContext.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }

    // Public API ------------------------------------------------------------//

    
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
    public AddJobFlowStepsResponse addJobFlowSteps(AddJobFlowStepsRequest request)
        throws AmazonElasticMapReduceException {
        AddJobFlowStepsResponse response;
        try {
            response = (AddJobFlowStepsResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("AddJobFlowStepsResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonElasticMapReduceException("Unable to process mock response", jbe);
        }
        return response;
    }

    
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
    public TerminateJobFlowsResponse terminateJobFlows(TerminateJobFlowsRequest request)
        throws AmazonElasticMapReduceException {
        TerminateJobFlowsResponse response;
        try {
            response = (TerminateJobFlowsResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("TerminateJobFlowsResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonElasticMapReduceException("Unable to process mock response", jbe);
        }
        return response;
    }

    
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
    public DescribeJobFlowsResponse describeJobFlows(DescribeJobFlowsRequest request)
        throws AmazonElasticMapReduceException {
        DescribeJobFlowsResponse response;
        try {
            response = (DescribeJobFlowsResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("DescribeJobFlowsResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonElasticMapReduceException("Unable to process mock response", jbe);
        }
        return response;
    }

    
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
    public RunJobFlowResponse runJobFlow(RunJobFlowRequest request)
        throws AmazonElasticMapReduceException {
        RunJobFlowResponse response;
        try {
            response = (RunJobFlowResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("RunJobFlowResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonElasticMapReduceException("Unable to process mock response", jbe);
        }
        return response;
    }


    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return unmarshaller.get();
    }
}