package no.kaicao.stocksurfer.flink.transformation;

import org.apache.flink.streaming.api.functions.source.RichSourceFunction;


public class DummySourceFunction extends RichSourceFunction<Integer> {

  private static final long serialVersionUID = -966339005909732085L;
  private volatile boolean isCanceled = false;


  @Override
  public void run(SourceContext<Integer> sourceContext) throws Exception {
    int i = 0;
    while (!isCanceled) {
      sourceContext.collect(i ++);
    }
  }

  @Override
  public void cancel() {
    isCanceled = true;
  }
}
