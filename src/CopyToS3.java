package com.wavemarket.hadoop;

import java.io.File;
import org.jets3t.service.S3Service;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;



/**
 * Copy files to S3
 */
public class CopyToS3 {

    public static void main(String[] args) throws Exception {

        // Step 1: Get command-line arguments
        String myAccessKey = args[0];
        String mySecretKey = args[1];
        String directoryName = args[2];

        /* Step 2: Create a credentials object and service to access
                your S3 account */
        AWSCredentials myCredentials =
           new AWSCredentials(myAccessKey, mySecretKey);
        S3Service myService = new RestS3Service(myCredentials);

        /* Step 3: Create a new bucket named after a normalized directory path,
                and include my Access Key ID to ensure the bucket name is unique */
        String bucketName =
           directoryName.replace('\\', '_').replace('/','_').replace(':', '_');
        S3Bucket myBucket =
           myService.createBucket(myAccessKey + "." + bucketName);

        // Step 4: Add files from specified directory to bucket
        File directory = new File(directoryName);
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                S3Object object = new S3Object(myBucket, files[i]);
                myService.putObject(myBucket, object);
            }
        }
    }
 	

}
 	


