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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**

 *
 */
public class AmazonElasticMapReduceAsyncClient extends AmazonElasticMapReduceClient implements AmazonElasticMapReduceAsync {

    private ExecutorService executor;

    /**
     * Client to make asynchronous calls to the service. Please note, you should
     * configure executor with same number of concurrent threads as number of
     * http connections specified in AmazonElasticMapReduceConfig. Default number of
     * max http connections is 100.
     *
     * @param awsAccessKeyId AWS Access Key Id
     * @param awsSecretAccessKey AWS Secret Key
     * @param config service configuration. Pass new AmazonElasticMapReduceConfig() if you
     * plan to use defaults
     *
     * @param executor Executor service to manage asynchronous calls.
     *
     */
    public AmazonElasticMapReduceAsyncClient(String awsAccessKeyId, String awsSecretAccessKey,
            AmazonElasticMapReduceConfig config, ExecutorService executor) {
        super(awsAccessKeyId, awsSecretAccessKey, config);
        this.executor = executor;
    }

        

    /**
     * Non-blocking Add Job Flow Steps 
     * <p/>
     * Returns <code>future</code> pointer to AddJobFlowStepsResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return AddJobFlowStepsResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonElasticMapReduceException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;AddJobFlowStepsResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;AddJobFlowStepsResponse&gt;&gt;();
     *  for (AddJobFlowStepsRequest request : requests) {
     *      responses.add(client.addJobFlowStepsAsync(request));
     *  }
     *  for (Future&lt;AddJobFlowStepsResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          AddJobFlowStepsResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonElasticMapReduceException) {
     *              AmazonElasticMapReduceException exception = AmazonElasticMapReduceException.class.cast(e);
     *          // handle AmazonElasticMapReduceException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          AddJobFlowStepsRequest request
     * @return Future&lt;AddJobFlowStepsResponse&gt; future pointer to AddJobFlowStepsResponse
     * 
     */
    public Future<AddJobFlowStepsResponse> addJobFlowStepsAsync(final AddJobFlowStepsRequest request) {
        Future<AddJobFlowStepsResponse> response = executor.submit(new Callable<AddJobFlowStepsResponse>() {

            public AddJobFlowStepsResponse call() throws AmazonElasticMapReduceException {
                return addJobFlowSteps(request);
            }
        });
        return response;
    }


        

    /**
     * Non-blocking Terminate Job Flows 
     * <p/>
     * Returns <code>future</code> pointer to TerminateJobFlowsResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return TerminateJobFlowsResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonElasticMapReduceException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;TerminateJobFlowsResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;TerminateJobFlowsResponse&gt;&gt;();
     *  for (TerminateJobFlowsRequest request : requests) {
     *      responses.add(client.terminateJobFlowsAsync(request));
     *  }
     *  for (Future&lt;TerminateJobFlowsResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          TerminateJobFlowsResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonElasticMapReduceException) {
     *              AmazonElasticMapReduceException exception = AmazonElasticMapReduceException.class.cast(e);
     *          // handle AmazonElasticMapReduceException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          TerminateJobFlowsRequest request
     * @return Future&lt;TerminateJobFlowsResponse&gt; future pointer to TerminateJobFlowsResponse
     * 
     */
    public Future<TerminateJobFlowsResponse> terminateJobFlowsAsync(final TerminateJobFlowsRequest request) {
        Future<TerminateJobFlowsResponse> response = executor.submit(new Callable<TerminateJobFlowsResponse>() {

            public TerminateJobFlowsResponse call() throws AmazonElasticMapReduceException {
                return terminateJobFlows(request);
            }
        });
        return response;
    }


        

    /**
     * Non-blocking Describe Job Flows 
     * <p/>
     * Returns <code>future</code> pointer to DescribeJobFlowsResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return DescribeJobFlowsResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonElasticMapReduceException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;DescribeJobFlowsResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;DescribeJobFlowsResponse&gt;&gt;();
     *  for (DescribeJobFlowsRequest request : requests) {
     *      responses.add(client.describeJobFlowsAsync(request));
     *  }
     *  for (Future&lt;DescribeJobFlowsResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          DescribeJobFlowsResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonElasticMapReduceException) {
     *              AmazonElasticMapReduceException exception = AmazonElasticMapReduceException.class.cast(e);
     *          // handle AmazonElasticMapReduceException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          DescribeJobFlowsRequest request
     * @return Future&lt;DescribeJobFlowsResponse&gt; future pointer to DescribeJobFlowsResponse
     * 
     */
    public Future<DescribeJobFlowsResponse> describeJobFlowsAsync(final DescribeJobFlowsRequest request) {
        Future<DescribeJobFlowsResponse> response = executor.submit(new Callable<DescribeJobFlowsResponse>() {

            public DescribeJobFlowsResponse call() throws AmazonElasticMapReduceException {
                return describeJobFlows(request);
            }
        });
        return response;
    }


        

    /**
     * Non-blocking Run Job Flow 
     * <p/>
     * Returns <code>future</code> pointer to RunJobFlowResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return RunJobFlowResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonElasticMapReduceException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;RunJobFlowResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;RunJobFlowResponse&gt;&gt;();
     *  for (RunJobFlowRequest request : requests) {
     *      responses.add(client.runJobFlowAsync(request));
     *  }
     *  for (Future&lt;RunJobFlowResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          RunJobFlowResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonElasticMapReduceException) {
     *              AmazonElasticMapReduceException exception = AmazonElasticMapReduceException.class.cast(e);
     *          // handle AmazonElasticMapReduceException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          RunJobFlowRequest request
     * @return Future&lt;RunJobFlowResponse&gt; future pointer to RunJobFlowResponse
     * 
     */
    public Future<RunJobFlowResponse> runJobFlowAsync(final RunJobFlowRequest request) {
        Future<RunJobFlowResponse> response = executor.submit(new Callable<RunJobFlowResponse>() {

            public RunJobFlowResponse call() throws AmazonElasticMapReduceException {
                return runJobFlow(request);
            }
        });
        return response;
    }


}
