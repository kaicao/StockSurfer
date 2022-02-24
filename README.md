## StockSurfer

Sample application for Flink deployment that single jar with multiple jobs.


### Install Flink
- Download Flink ```https://www.apache.org/dyn/closer.lua/flink/flink-1.14.3/flink-1.14.3-bin-scala_2.12.tgz```
- Unzip to local folder
- Update environment variable, e.g. for my Mac
```
vi ~/.bash_profile
export FLINK_HOME=/Users/kai/Documents/Services/flink-1.14.3
export PATH=$PATH:$FLINK_HOME/bin
```
- Verify Flink is working
```
start-cluster.sh
# then check browser http://localhost:8081 there should be Flink portal ready
stop-cluster.sh 
```

### Polygon.io
polygon.io provides free market data e.g. stocks that will be used to 
provide source data for `StockSurfer`.
- REST API doc can be found at https://polygon.io/docs/stocks/getting-started

### Submit job
The `DummyJob` defined parallelism of 4 (max among pipeline steps).
Thus require 4 task manager available per job.
In case there are 2 jobs, then require 8 task managers in order to run the jobs.

Submit job by 
```
# start cluster
start-cluster.sh
# repeat task manager starts until enough task managers are created
taskmanager.sh start 

flink run flink-job/target/stocksurfer-flink-job-1.0.0-SNAPSHOT-shaded.jar
# Should show result that such as below, that shows multiple job submitted:
Job has been submitted with JobID bfd6b30a81051e9607a0b5da63e5c2ca
Job has been submitted with JobID 84fd014c23244a271e77b8c850dbbd13

# stop cluster
stop-cluster.sh
```


Check from localhost:8081 that 2 jobs are running.