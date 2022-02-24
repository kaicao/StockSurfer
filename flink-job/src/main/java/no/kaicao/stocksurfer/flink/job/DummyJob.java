package no.kaicao.stocksurfer.flink.job;

import no.kaicao.stocksurfer.flink.transformation.DummyMapFunction;
import no.kaicao.stocksurfer.flink.transformation.DummySinkFunction;
import no.kaicao.stocksurfer.flink.transformation.DummySourceFunction;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DummyJob {

  void createJob(StreamExecutionEnvironment env, String jobName) {
    env.addSource(new DummySourceFunction())
        .uid(jobName + "-source-1")
        .name("dummySource")
        .setParallelism(1)
        .map(new DummyMapFunction())
        .uid(jobName + "-map-1")
        .name("dummyMap")
        .setParallelism(4)
        .addSink(new DummySinkFunction())
        .uid(jobName + "-sink-1")
        .name("dummySync")
        .setParallelism(1);
  }
}
