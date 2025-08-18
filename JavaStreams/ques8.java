import java.io.*;

public class ques8 {
    public static void main(String[] args) {
        try {
           
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // connect the streams

                        Thread writerThread = new Thread(new Writer(pos));
           
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


class Writer implements Runnable {
    private PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (OutputStreamWriter writer = new OutputStreamWriter(pos)) {
            String message = "Hello from Writer Thread!";
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}


class Reader implements Runnable {
    private PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (InputStreamReader reader = new InputStreamReader(pis)) {
            int data;
            System.out.print("Reader received: ");
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}
