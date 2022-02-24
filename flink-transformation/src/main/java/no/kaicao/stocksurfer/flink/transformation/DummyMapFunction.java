package no.kaicao.stocksurfer.flink.transformation;

import org.apache.flink.api.common.functions.RichMapFunction;

public class DummyMapFunction extends RichMapFunction<Integer, String> {

  private static final long serialVersionUID = 7702612920029453119L;

  @Override
  public String map(Integer input) throws Exception {
    if (input == null) {
      return null;
    }
    return String.valueOf((char) (input % 127));
  }
}
