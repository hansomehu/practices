package lang.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIO {
    public static void main(String[] args) throws IOException {
        new NIOServer().init();
        new NIOClient().init();
    }
}

class NIOServer{
    public void init() throws IOException {
        ServerSocketChannel svrChannel = ServerSocketChannel.open();
        svrChannel.socket().bind(new InetSocketAddress(8080));
        svrChannel.configureBlocking(false); // configure non-blocking way

        Selector selector = Selector.open();
    }
}

class NIOClient{
    public void init(){

    }

}

/*
the worker task of the selector
responsible for polling
 */
class ReactorTask implements Runnable{

    @Override
    public void run() {

    }
}
