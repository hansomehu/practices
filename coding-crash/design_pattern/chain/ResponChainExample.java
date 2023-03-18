package design_pattern.chain;

public class ResponChainExample {
    public static void main(String[] args) {

    }
}

abstract class Handler{
    Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void process();
}

class LayerOne extends Handler{

    public LayerOne(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void process() {
        System.out.println();
        nextHandler.process();
    }
}

class LayerTwo extends Handler{

    public LayerTwo(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void process() {

    }
}
