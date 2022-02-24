package no.kaicao.stocksurfer.flink.job;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DummyJobMain {

  public static void main(String[] args) throws Exception {

    StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

    DummyJob dummyJobCreator = new DummyJob();

    dummyJobCreator.createJob(environment, "job1");
    environment.executeAsync("job1");

    dummyJobCreator.createJob(environment, "job2");
    environment.executeAsync("job2");
  }
}
