package com.eucalyptus.s3;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.eucatester.EucaTester;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class BucketVersioning {
  public static void main( String[] args ) {
    EucaTester tester = new EucaTester( "eucarc" );

    Bucket bucket = tester.s3.createBucket( tester.s3.getResourceName( "bucket" ) );
    tester.s3.enableBucketVersioningConfiguration( bucket.getName( ) );

    File file = tester.s3.getTextObjectFile( );
    PutObjectResult putObjectResult1 = tester.s3.putObjectIntoBucket( bucket.getName( ), file.getAbsolutePath( ) );

    tester.s3.updateTextObjectFile( file );
    PutObjectResult putObjectResult2 = tester.s3.putObjectIntoBucket( bucket.getName( ), file.getAbsolutePath( ) );

    ObjectListing objectListing = tester.s3.listBucketObjects( bucket.getName( ) );
    List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries( );
    for ( S3ObjectSummary objectSummary : objectSummaries ) {
      assertTrue( objectSummary.getETag( ).equals( putObjectResult2.getETag( ) ) );
    }

//    CleanUp
    tester.s3.deleteAllObjectsFromVersionedBucket( bucket.getName( ) );
    tester.s3.deleteBucket( bucket.getName( ) );

  }
}
