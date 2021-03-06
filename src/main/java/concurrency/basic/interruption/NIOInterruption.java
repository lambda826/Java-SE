package concurrency.basic.interruption;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class NIOInterruption {

    private static class NIOBlocked implements Runnable {
        private final SocketChannel sc;

        public NIOBlocked(SocketChannel sc) {
            this.sc = sc;
        }

        public void run() {
            try {
                println("Waiting for read() in " + this);
                sc.read(ByteBuffer.allocate(1));
            } catch (ClosedByInterruptException e) {
                println("ClosedByInterruptException");
            } catch (AsynchronousCloseException e) {
                println("AsynchronousCloseException");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            println("Exiting NIOBlocked.run() " + this);
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        // Produce an interrupt via cancel:
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        // Release the block by closing the channel:
        sc2.close();
    }
}