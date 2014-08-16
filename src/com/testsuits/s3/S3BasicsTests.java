package com.testsuits.s3;

import com.eucatester.EucaTester;
import com.google.common.collect.Multimap;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class S3BasicsTests {

  EucaTester tester = new EucaTester( "eucarc" );

  @Test
  public void objectPutGetDeleteTest( ) {
//    PropertyConfigurator.configure( "log4j.properties" );

    System.out.println( "\nStarting PUT object test..." );
    Multimap<String, String> bucketObjectList = tester.s3.putObjectsTest();

    System.out.println( "\nStarting GET object test..." );
    Set<String> keys = bucketObjectList.keySet();

    String bucketName = null;
    List<String> keyNames = null;

    for ( String key : keys) {
      bucketName = key;
      keyNames = new ArrayList<String>( bucketObjectList.get( key ) );
      tester.s3.getObject( bucketName, keyNames );
    }

    System.out.println( "\nStarting DELETE object test..." );
    tester.s3.deleteAllObjectsFromBucket( bucketName );
    tester.s3.deleteBucket( bucketName );
  }
}
