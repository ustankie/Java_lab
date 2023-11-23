package agh.ics.oop.model;
import java.io.OutputStream;
import java.io.PrintStream;

public class SynchronizedPrintStream extends PrintStream {
    public SynchronizedPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public synchronized void println(String x) {
        super.println(x);
    }
}