eucatester-tests
================

Test cases for EucaTester


### Run Tests
    git clone https://github.com/shaon/eucatester-tests.git
    cd eucatester-tests
    ant build

#### Command-line
    ant build
    export EUCATESTER_HOME=/path/to/eucatester-tests
    (e.g /Users/shaon/IdeaProjects/eucatester-tests)
    
    java \
    -Dcom.amazonaws.regions.RegionUtils.fileOverride=$EUCATESTER_HOME/endpoints.xml \
    -classpath "$EUCATESTER_HOME/build/classes:$EUCATESTER_HOME/lib/*" \
    com.s3tests.BucketPGD

### Run Test Suits

#### Command-line
    ant build
    export EUCATESTER_HOME=/path/to/eucatester-tests
    (e.g /Users/shaon/IdeaProjects/eucatester-tests)
    
    java \
    -Dcom.amazonaws.regions.RegionUtils.fileOverride=$EUCATESTER_HOME/endpoints.xml \
    -classpath "$EUCATESTER_HOME/build/classes:$EUCATESTER_HOME/lib/*" \
    org.testng.TestNG $EUCATESTER_HOME/TestSuites/S3Suite.xml
