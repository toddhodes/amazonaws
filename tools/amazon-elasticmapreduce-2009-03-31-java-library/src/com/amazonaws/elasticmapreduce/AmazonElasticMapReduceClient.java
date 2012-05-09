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

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpMethodRetryHandler;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NoHttpResponseException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import javax.xml.transform.stream.StreamSource;





/**

 *
 *
 * AmazonElasticMapReduceClient is implementation of AmazonElasticMapReduce based on the
 * Apache <a href="http://jakarta.apache.org/commons/httpclient/">HttpClient</a>.
 *
 */
public  class AmazonElasticMapReduceClient implements AmazonElasticMapReduce {

    private final Log log = LogFactory.getLog(AmazonElasticMapReduceClient.class);

    private String awsAccessKeyId = null;
    private String awsSecretAccessKey = null;
    private AmazonElasticMapReduceConfig config = null;
    private HttpClient httpClient = null;
    private static JAXBContext  jaxbContext;
    private static ThreadLocal<Unmarshaller> unmarshaller;
    private static Pattern ERROR_PATTERN_ONE = Pattern.compile(".*\\<RequestId>(.*)\\</RequestId>.*\\<Error>" +
            "\\<Code>(.*)\\</Code>\\<Message>(.*)\\</Message>\\</Error>.*(\\<Error>)?.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern ERROR_PATTERN_TWO = Pattern.compile(".*\\<Error>\\<Code>(.*)\\</Code>\\<Message>(.*)" +
            "\\</Message>\\</Error>.*(\\<Error>)?.*\\<RequestID>(.*)\\</RequestID>.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static String DEFAULT_ENCODING = "UTF-8";
    /** Initialize JAXBContext and  Unmarshaller **/
    static {
        try {
            jaxbContext = JAXBContext.newInstance("com.amazonaws.elasticmapreduce.model", AmazonElasticMapReduce.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            @Override
            protected synchronized Unmarshaller initialValue() {
                try {
                    return jaxbContext.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }


    /**
     * Constructs AmazonElasticMapReduceClient with AWS Access Key ID and AWS Secret Key
     *
     * @param awsAccessKeyId
     *          AWS Access Key ID
     * @param awsSecretAccessKey
     *          AWS Secret Access Key
     */
    public  AmazonElasticMapReduceClient(String awsAccessKeyId,String awsSecretAccessKey) {
        this (awsAccessKeyId, awsSecretAccessKey, new AmazonElasticMapReduceConfig());
    }



    /**
     * Constructs AmazonElasticMapReduceClient with AWS Access Key ID, AWS Secret Key
     * and AmazonElasticMapReduceConfig. Use AmazonElasticMapReduceConfig to pass additional
     * configuration that affects how service is being called.
     *
     * @param awsAccessKeyId
     *          AWS Access Key ID
     * @param awsSecretAccessKey
     *          AWS Secret Access Key
     * @param config
     *          Additional configuration options
     */
    public  AmazonElasticMapReduceClient(String awsAccessKeyId, String awsSecretAccessKey,
            AmazonElasticMapReduceConfig config) {
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretAccessKey = awsSecretAccessKey;
        this.config = config;
        this.httpClient = configureHttpClient();
    }

    // Public API ------------------------------------------------------------//


    
    /**
     * Add Job Flow Steps 
     *

     * @param request
     *          AddJobFlowStepsRequest request
     * @return
     *          AddJobFlowSteps Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public AddJobFlowStepsResponse addJobFlowSteps(AddJobFlowStepsRequest request) throws AmazonElasticMapReduceException {
        return invoke(AddJobFlowStepsResponse.class, convertAddJobFlowSteps(request));
    }

    
    /**
     * Terminate Job Flows 
     *

     * @param request
     *          TerminateJobFlowsRequest request
     * @return
     *          TerminateJobFlows Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public TerminateJobFlowsResponse terminateJobFlows(TerminateJobFlowsRequest request) throws AmazonElasticMapReduceException {
        return invoke(TerminateJobFlowsResponse.class, convertTerminateJobFlows(request));
    }

    
    /**
     * Describe Job Flows 
     *

     * @param request
     *          DescribeJobFlowsRequest request
     * @return
     *          DescribeJobFlows Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public DescribeJobFlowsResponse describeJobFlows(DescribeJobFlowsRequest request) throws AmazonElasticMapReduceException {
        return invoke(DescribeJobFlowsResponse.class, convertDescribeJobFlows(request));
    }

    
    /**
     * Run Job Flow 
     *

     * @param request
     *          RunJobFlowRequest request
     * @return
     *          RunJobFlow Response from the service
     *
     * @throws AmazonElasticMapReduceException
     */
    public RunJobFlowResponse runJobFlow(RunJobFlowRequest request) throws AmazonElasticMapReduceException {
        return invoke(RunJobFlowResponse.class, convertRunJobFlow(request));
    }



    // Private API ------------------------------------------------------------//

    /**
     * Configure HttpClient with set of defaults as well as configuration
     * from AmazonElasticMapReduceConfig instance
     *
     */
    private HttpClient configureHttpClient() {

        /* Set http client parameters */
        HttpClientParams httpClientParams = new HttpClientParams();
        httpClientParams.setParameter(HttpMethodParams.USER_AGENT, config.getUserAgent());
        httpClientParams.setParameter(HttpClientParams.RETRY_HANDLER, new HttpMethodRetryHandler() {

            public boolean retryMethod(HttpMethod method, IOException exception, int executionCount) {
                if (executionCount > 3) {
                    log.debug("Maximum Number of Retry attempts reached, will not retry");
                    return false;
                }
                log.debug("Retrying request. Attempt " + executionCount);
                if (exception instanceof NoHttpResponseException) {
                    log.debug("Retrying on NoHttpResponseException");
                    return true;
                }
                if (exception instanceof InterruptedIOException) {
                    log.debug("Will not retry on InterruptedIOException", exception);
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    log.debug("Will not retry on UnknownHostException", exception);
                    return false;
                }
                if (!method.isRequestSent()) {
                    log.debug("Retrying on failed sent request");
                    return true;
                }
                return false;
            }
        });

        /* Set host configuration */
        HostConfiguration hostConfiguration = new HostConfiguration();

        /* Set connection manager parameters */
        HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
        connectionManagerParams.setConnectionTimeout(50000);
        connectionManagerParams.setSoTimeout(50000);
        connectionManagerParams.setStaleCheckingEnabled(true);
        connectionManagerParams.setTcpNoDelay(true);
        connectionManagerParams.setMaxTotalConnections(config.getMaxConnections());
        connectionManagerParams.setMaxConnectionsPerHost(hostConfiguration, config.getMaxConnections());

        /* Set connection manager */
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.setParams(connectionManagerParams);

        /* Set http client */
        httpClient = new HttpClient(httpClientParams, connectionManager);

        /* Set proxy if configured */
        if (config.isSetProxyHost() && config.isSetProxyPort()) {
            log.info("Configuring Proxy. Proxy Host: " + config.getProxyHost() +
                    "Proxy Port: " + config.getProxyPort() );
            hostConfiguration.setProxy(config.getProxyHost(), config.getProxyPort());
            if (config.isSetProxyUsername() &&   config.isSetProxyPassword()) {
                httpClient.getState().setProxyCredentials (new AuthScope(
                                          config.getProxyHost(),
                                          config.getProxyPort()),
                                          new UsernamePasswordCredentials(
                                              config.getProxyUsername(),
                                              config.getProxyPassword()));

            }
        }

        httpClient.setHostConfiguration(hostConfiguration);
        return httpClient;
    }

    /**
     * Invokes request using parameters from parameters map.
     * Returns response of the T type passed to this method
     */
    private <T> T invoke(Class<T> clazz, Map<String, String> parameters)
            throws AmazonElasticMapReduceException {

        String actionName = parameters.get("Action");
        T response = null;
        String responseBodyString = null;
        PostMethod method = new PostMethod(config.getServiceURL());
        int status = -1;

        log.debug("Invoking" + actionName + " request. Current parameters: " + parameters);

        try {

            /* Set content type and encoding */
            log.debug("Setting content-type to application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());

            /* Add required request parameters and set request body */
            log.debug("Adding required parameters...");
            addRequiredParametersToRequest(method, parameters);
            log.debug("Done adding additional required parameteres. Parameters now: " + parameters);

            boolean shouldRetry = true;
            int retries = 0;
            do {
                log.debug("Sending Request to host:  " + config.getServiceURL());

                try {

                    /* Submit request */
                    status = httpClient.executeMethod(method);



                    /* Consume response stream */
                    responseBodyString = getResponsBodyAsString(method.getResponseBodyAsStream());

                    /* Successful response. Attempting to unmarshal into the <Action>Response type */
                    if (status == HttpStatus.SC_OK) {
                        shouldRetry = false;
                        log.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);
                        if (responseBodyString != null && responseBodyString.trim().endsWith(actionName + "Response>")) {
                            log.debug("Attempting to transform " + actionName + "Response type...");
                            responseBodyString = ResponseTransformer.transform(responseBodyString);
                            log.debug("Transformed response to: " + responseBodyString);
                        }
                        log.debug("Attempting to unmarshal into the " + actionName + "Response type...");
                        response = clazz.cast(getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString))));

                        log.debug("Unmarshalled response into " + actionName + "Response type.");

                    } else { /* Unsucessful response. Attempting to unmarshall into ErrorResponse  type */

                        log.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);

                        if ((status == HttpStatus.SC_INTERNAL_SERVER_ERROR
                            || status == HttpStatus.SC_SERVICE_UNAVAILABLE)
                            && pauseIfRetryNeeded(++retries)){
                            shouldRetry = true;
                        } else {
                            log.debug("Attempting to unmarshal into the ErrorResponse type...");
                            ErrorResponse errorResponse = (ErrorResponse) getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString)));

                            log.debug("Unmarshalled response into the ErrorResponse type.");

                            com.amazonaws.elasticmapreduce.model.Error error = errorResponse.getError().get(0);

                                    throw new AmazonElasticMapReduceException(error.getMessage(),
                                    status,
                                    error.getCode(),
                                    error.getType(),
                                    errorResponse.getRequestId(),
                                    errorResponse.toXML());
                        }
                    }
                } catch (JAXBException je) {
                    /* Response cannot be unmarshalled neither as <Action>Response or ErrorResponse types.
                    Checking for other possible errors. */

                    log.debug ("Caught JAXBException", je);
                    log.debug("Response cannot be unmarshalled neither as " + actionName + "Response or ErrorResponse types." +
                            "Checking for other possible errors.");

                    AmazonElasticMapReduceException awse = processErrors(responseBodyString, status);

                    throw awse;

                } catch (IOException ioe) {
                    log.debug("Caught IOException exception", ioe);
                    throw new AmazonElasticMapReduceException("Internal Error", ioe);
                } catch (Exception e) {
                    log.debug("Caught Exception", e);
                    throw new AmazonElasticMapReduceException(e);
                } finally {
                    method.releaseConnection();
                }
            } while (shouldRetry);

        } catch (AmazonElasticMapReduceException se) {
            log.debug("Caught AmazonElasticMapReduceException", se);
            throw se;

        } catch (Throwable t) {
            log.debug("Caught Exception", t);
            throw new AmazonElasticMapReduceException(t);
        }
        return response;
    }

    /**
     * Read stream into string
     * @param input stream to read
     */
    private String getResponsBodyAsString(InputStream input) throws IOException {
        String responsBodyString = null;
        try {
            Reader reader = new InputStreamReader(input, DEFAULT_ENCODING);
            StringBuilder b = new StringBuilder();
            char[] c = new char[1024];
            int len;
            while (0 < (len = reader.read(c))) {
                b.append(c, 0, len);
            }
            responsBodyString = b.toString();
        } finally {
            input.close();
        }
        return responsBodyString;
    }

    /**
     * Exponential sleep on failed request. Sleeps and returns true if retry needed
     * @param retries current retry
     * @throws java.lang.InterruptedException
     */
    private boolean pauseIfRetryNeeded(int retries)
          throws InterruptedException {
        if (retries <= config.getMaxErrorRetry()) {
            long delay = (long) (Math.pow(4, retries) * 100L);
            log.debug("Retriable error detected, will retry in " + delay + "ms, attempt numer: " + retries);
            Thread.sleep(delay);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add authentication related and version parameter and set request body
     * with all of the parameters
     */
    private void addRequiredParametersToRequest(PostMethod method, Map<String, String> parameters)
            throws SignatureException {
        parameters.put("Version", config.getServiceVersion());
        parameters.put("SignatureVersion", config.getSignatureVersion());
        parameters.put("Timestamp", getFormattedTimestamp());
        parameters.put("AWSAccessKeyId",  this.awsAccessKeyId);
        parameters.put("Signature", signParameters(parameters, this.awsSecretAccessKey));
        for (Entry<String, String> entry : parameters.entrySet()) {
            method.addParameter(entry.getKey(), entry.getValue());
        }
    }

    private AmazonElasticMapReduceException processErrors(String responseString, int status)  {
        AmazonElasticMapReduceException ex = null;
        Matcher matcher = null;
        if (responseString != null && responseString.startsWith("<")) {
            matcher = ERROR_PATTERN_ONE.matcher(responseString);
            if (matcher.matches()) {
                ex = new AmazonElasticMapReduceException(matcher.group(3), status,
                        matcher.group(2), "Unknown", matcher.group(1), responseString);
            } else {
                matcher = ERROR_PATTERN_TWO.matcher(responseString);
                if (matcher.matches()) {
                    ex = new AmazonElasticMapReduceException(matcher.group(2), status,
                            matcher.group(1), "Unknown", matcher.group(4), responseString);
            } else {
                ex =  new AmazonElasticMapReduceException("Internal Error", status);
                log.debug("Service Error. Response Status: " + status);
            }
            }
        } else {
            ex =  new AmazonElasticMapReduceException("Internal Error", status);
            log.debug("Service Error. Response Status: " + status);
        }
        return ex;
    }

    /**
     * Formats date as ISO 8601 timestamp
     */
    private String getFormattedTimestamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }

    /**
     * Computes RFC 2104-compliant HMAC signature for request parameters
     * Implements AWS Signature, as per following spec:
     *
     * If Signature Version is 0, it signs concatenated Action and Timestamp
     *
     * If Signature Version is 1, it performs the following:
     *
     * Sorts all  parameters (including SignatureVersion and excluding Signature,
     * the value of which is being created), ignoring case.
     *
     * Iterate over the sorted list and append the parameter name (in original case)
     * and then its value. It will not URL-encode the parameter values before
     * constructing this string. There are no separators.
     *
     * If Signature Version is 2, string to sign is based on following:
     *
     *    1. The HTTP Request Method followed by an ASCII newline (%0A)
     *    2. The HTTP Host header in the form of lowercase host, followed by an ASCII newline.
     *    3. The URL encoded HTTP absolute path component of the URI
     *       (up to but not including the query string parameters);
     *       if this is empty use a forward '/'. This parameter is followed by an ASCII newline.
     *    4. The concatenation of all query string components (names and values)
     *       as UTF-8 characters which are URL encoded as per RFC 3986
     *       (hex characters MUST be uppercase), sorted using lexicographic byte ordering.
     *       Parameter names are separated from their values by the '=' character
     *       (ASCII character 61), even if the value is empty.
     *       Pairs of parameter and values are separated by the '&' character (ASCII code 38).
     *
     */
    private String signParameters(Map<String, String> parameters, String key)
            throws  SignatureException {

        String signatureVersion = parameters.get("SignatureVersion");
        String algorithm = "HmacSHA1";
        String stringToSign = null;
        if ("0".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV0(parameters);
        } else if ("1".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV1(parameters);
        } else if ("2".equals(signatureVersion)) {
            algorithm = config.getSignatureMethod();
            parameters.put("SignatureMethod", algorithm);
            stringToSign = calculateStringToSignV2(parameters);
        } else {
            throw new SignatureException("Invalid Signature Version specified");
        }
        log.debug("Calculated string to sign: " + stringToSign);
        return sign(stringToSign, key, algorithm);
    }

    /**
     * Calculate String to Sign for SignatureVersion 0
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV0(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
            data.append(parameters.get("Action")).append(parameters.get("Timestamp"));
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 1
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV1(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
            Map<String, String> sorted =  new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
            sorted.putAll(parameters);
            Iterator pairs = sorted.entrySet().iterator();
            while (pairs.hasNext()) {
                Map.Entry pair = (Map.Entry)pairs.next();
                data.append(pair.getKey());
                data.append(pair.getValue());
            }
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 2
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV2(Map<String, String> parameters)
            throws SignatureException {
        StringBuilder data = new StringBuilder();
        data.append("POST");
        data.append("\n");
        URI endpoint = null;
        try {
            endpoint = new URI(config.getServiceURL().toLowerCase());
        } catch (URISyntaxException ex) {
            log.debug("URI Syntax Exception", ex);
            throw new SignatureException("URI Syntax Exception thrown " +
                    "while constructing string to sign", ex);
        }
        data.append(endpoint.getHost());
        data.append("\n");
        String uri = endpoint.getPath();
        if (uri == null || uri.length() == 0) {
            uri = "/";
        }
        data.append(urlEncode(uri, true));
        data.append("\n");
        Map<String, String> sorted = new TreeMap<String, String>();
        sorted.putAll(parameters);
        Iterator<Map.Entry<String, String>> pairs = sorted.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            String key = pair.getKey();
            data.append(urlEncode(key, false));
            data.append("=");
            String value = pair.getValue();
            data.append(urlEncode(value, false));
            if (pairs.hasNext()) {
                data.append("&");
            }
        }
        return data.toString();
    }

    private String urlEncode(String value, boolean path) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, DEFAULT_ENCODING)
                                        .replace("+", "%20")
                                        .replace("*", "%2A")
                                        .replace("%7E","~");
            if (path) {
                encoded = encoded.replace("%2F", "/");
            }
        } catch (UnsupportedEncodingException ex) {
            log.debug("Unsupported Encoding Exception", ex);
            throw new RuntimeException(ex);
        }
        return encoded;
    }

    /**
     * Computes RFC 2104-compliant HMAC signature.
     *
     */
    private String sign(String data, String key, String algorithm) throws SignatureException {
        byte [] signature;
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.getBytes(), algorithm));
            signature = Base64.encodeBase64(mac.doFinal(data.getBytes(DEFAULT_ENCODING)));
        } catch (Exception e) {
            throw new SignatureException("Failed to generate signature: " + e.getMessage(), e);
        }

        return new String(signature);
    }

    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return unmarshaller.get();
    }
    
    
    
                    
   /**
     * Convert AddJobFlowStepsRequest to name value pairs
     */
    private Map<String, String> convertAddJobFlowSteps(AddJobFlowStepsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "AddJobFlowSteps");
        if (request.isSetJobFlowId()) {
            params.put("JobFlowId", request.getJobFlowId());
        }
        java.util.List<StepConfig> stepsList = request.getSteps();
        int stepsListIndex = 1;
        for (StepConfig steps : stepsList) {
            if (steps.isSetName()) {
                params.put("Steps" + ".member."  + stepsListIndex + "." + "Name", steps.getName());
            }
            if (steps.isSetActionOnFailure()) {
                params.put("Steps" + ".member."  + stepsListIndex + "." + "ActionOnFailure", steps.getActionOnFailure());
            }
            if (steps.isSetHadoopJarStep()) {
                HadoopJarStepConfig  hadoopJarStep = steps.getHadoopJarStep();
                java.util.List<KeyValue> propertiesList = hadoopJarStep.getProperties();
                int propertiesListIndex = 1;
                for (KeyValue properties : propertiesList) {
                    if (properties.isSetKey()) {
                        params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Properties" + ".member."  + propertiesListIndex + "." + "Key", properties.getKey());
                    }
                    if (properties.isSetValue()) {
                        params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Properties" + ".member."  + propertiesListIndex + "." + "Value", properties.getValue());
                    }

                    propertiesListIndex++;
                }
                if (hadoopJarStep.isSetJar()) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Jar", hadoopJarStep.getJar());
                }
                if (hadoopJarStep.isSetMainClass()) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "MainClass", hadoopJarStep.getMainClass());
                }
                java.util.List<String> argsList  =  hadoopJarStep.getArgs();
                int argsListIndex = 1;
                for  (String args : argsList) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Args" + ".member."  + argsListIndex, args);
                    argsListIndex++;
                }
            }

            stepsListIndex++;
        }

        return params;
    }
        
        
    
                    
   /**
     * Convert TerminateJobFlowsRequest to name value pairs
     */
    private Map<String, String> convertTerminateJobFlows(TerminateJobFlowsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "TerminateJobFlows");
        java.util.List<String> jobFlowIdsList  =  request.getJobFlowIds();
        int jobFlowIdsListIndex = 1;
        for  (String jobFlowIds : jobFlowIdsList) {
            params.put("JobFlowIds" + ".member."  + jobFlowIdsListIndex, jobFlowIds);
            jobFlowIdsListIndex++;
        }

        return params;
    }
        
        
    
                    
   /**
     * Convert DescribeJobFlowsRequest to name value pairs
     */
    private Map<String, String> convertDescribeJobFlows(DescribeJobFlowsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "DescribeJobFlows");
        if (request.isSetCreatedAfter()) {
            params.put("CreatedAfter", request.getCreatedAfter());
        }
        if (request.isSetCreatedBefore()) {
            params.put("CreatedBefore", request.getCreatedBefore());
        }
        java.util.List<String> jobFlowIdsList  =  request.getJobFlowIds();
        int jobFlowIdsListIndex = 1;
        for  (String jobFlowIds : jobFlowIdsList) {
            params.put("JobFlowIds" + ".member."  + jobFlowIdsListIndex, jobFlowIds);
            jobFlowIdsListIndex++;
        }
        java.util.List<String> jobFlowStatesList  =  request.getJobFlowStates();
        int jobFlowStatesListIndex = 1;
        for  (String jobFlowStates : jobFlowStatesList) {
            params.put("JobFlowStates" + ".member."  + jobFlowStatesListIndex, jobFlowStates);
            jobFlowStatesListIndex++;
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert RunJobFlowRequest to name value pairs
     */
    private Map<String, String> convertRunJobFlow(RunJobFlowRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "RunJobFlow");
        if (request.isSetName()) {
            params.put("Name", request.getName());
        }
        if (request.isSetLogUri()) {
            params.put("LogUri", request.getLogUri());
        }
        if (request.isSetInstances()) {
            JobFlowInstancesConfig  instances = request.getInstances();
            if (instances.isSetMasterInstanceType()) {
                params.put("Instances" + "." + "MasterInstanceType", instances.getMasterInstanceType());
            }
            if (instances.isSetSlaveInstanceType()) {
                params.put("Instances" + "." + "SlaveInstanceType", instances.getSlaveInstanceType());
            }
            if (instances.isSetInstanceCount()) {
                params.put("Instances" + "." + "InstanceCount", instances.getInstanceCount() + "");
            }
            if (instances.isSetEc2KeyName()) {
                params.put("Instances" + "." + "Ec2KeyName", instances.getEc2KeyName());
            }
            if (instances.isSetPlacement()) {
                PlacementType  placement = instances.getPlacement();
                if (placement.isSetAvailabilityZone()) {
                    params.put("Instances" + "." + "Placement" + "." + "AvailabilityZone", placement.getAvailabilityZone());
                }
            }
            if (instances.isSetKeepJobFlowAliveWhenNoSteps()) {
                params.put("Instances" + "." + "KeepJobFlowAliveWhenNoSteps", instances.isKeepJobFlowAliveWhenNoSteps() + "");
            }
        }
        java.util.List<StepConfig> stepsList = request.getSteps();
        int stepsListIndex = 1;
        for (StepConfig steps : stepsList) {
            if (steps.isSetName()) {
                params.put("Steps" + ".member."  + stepsListIndex + "." + "Name", steps.getName());
            }
            if (steps.isSetActionOnFailure()) {
                params.put("Steps" + ".member."  + stepsListIndex + "." + "ActionOnFailure", steps.getActionOnFailure());
            }
            if (steps.isSetHadoopJarStep()) {
                HadoopJarStepConfig  hadoopJarStep = steps.getHadoopJarStep();
                java.util.List<KeyValue> propertiesList = hadoopJarStep.getProperties();
                int propertiesListIndex = 1;
                for (KeyValue properties : propertiesList) {
                    if (properties.isSetKey()) {
                        params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Properties" + ".member."  + propertiesListIndex + "." + "Key", properties.getKey());
                    }
                    if (properties.isSetValue()) {
                        params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Properties" + ".member."  + propertiesListIndex + "." + "Value", properties.getValue());
                    }

                    propertiesListIndex++;
                }
                if (hadoopJarStep.isSetJar()) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Jar", hadoopJarStep.getJar());
                }
                if (hadoopJarStep.isSetMainClass()) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "MainClass", hadoopJarStep.getMainClass());
                }
                java.util.List<String> argsList  =  hadoopJarStep.getArgs();
                int argsListIndex = 1;
                for  (String args : argsList) {
                    params.put("Steps" + ".member."  + stepsListIndex + "." + "HadoopJarStep" + "." + "Args" + ".member."  + argsListIndex, args);
                    argsListIndex++;
                }
            }

            stepsListIndex++;
        }

        return params;
    }
        
        
    
    
    
    
    
    
    
    
    
    
    
    



    private static class ResponseTransformer {

        /**
         * Transforms XML with XSLT into string.
         * @param response XML string of the response
         * @param actionName action name to perform the transformation on
         * @return transformed string
         */
        private static String transform(String response) {
            return transform(fromString(response),
                    fromResource(), null);
        }

        /**
         * Transforms XML with XSLT into string.
         * @param xml source document
         * @param xslt source template
         * @param parameters map of parameters to pass to XSLT for transformation
         * @return transformed string
         */
        private static String transform(Source xml, Source xslt, Map<String, String> parameters) {
            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer(xslt);
                StringWriter output = new StringWriter();
                if (parameters != null) {
                    for (Entry<String, String> entry : parameters.entrySet()) {
                        transformer.setParameter(entry.getKey(), entry.getValue());
                    }
                }
                transformer.transform(xml, new StreamResult(output));
                return output.toString();
            } catch (Exception ex) {
                throw new RuntimeException("XSLT transformation failed", ex);
            }
        }

        private static Source fromString(String string) {
            return new StreamSource(new StringReader(string));
        }

        private static Source fromResource() {
            return new StreamSource(AmazonElasticMapReduce.class.getClassLoader()
                    .getResourceAsStream("com/amazonaws/elasticmapreduce/model/" + "ResponseTransformer.xslt"));
        }
    }



}