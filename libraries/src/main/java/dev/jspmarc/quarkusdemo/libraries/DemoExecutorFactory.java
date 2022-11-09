package dev.jspmarc.quarkusdemo.libraries;

import java.util.concurrent.ThreadFactory;

public class DemoExecutorFactory implements ThreadFactory {

  private String prefix;
  private int counter = 0;

  public DemoExecutorFactory(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, prefix + "-" + counter++);
  }
}
