package com.eucalyptus.s3;

import com.amazonaws.services.s3.model.Bucket;
import com.eucatester.EucaTester;

import java.util.List;


public class BucketPGD {
  public static void main( String [] args ) {
    EucaTester tester = new EucaTester( "eucarc" );

    System.out.println( "\nStarting CREATE bucket test..." );
    List<Bucket> buckets = tester.s3.createBucketTest( );

    System.out.println( "\nStarting LIST bucket test..." );
    tester.s3.listBuckets( );

    System.out.println( "\nStarting DELETE bucket test..." );
    tester.s3.deleteBuckets( buckets );
  }
}
