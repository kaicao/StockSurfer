package no.kaicao.stocksurfer.flink.transformation;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.util.Date;

public class DummySinkFunction extends RichSinkFunction<String> {

  private static final long serialVersionUID = 2571308413308722304L;

  @Override
  public void invoke(String value, Context context) throws Exception {
    System.out.println(String.format("%s received %s, watermark %s", getRuntimeContext().getJobId(), value, new Date(context.currentWatermark())));
  }
}
