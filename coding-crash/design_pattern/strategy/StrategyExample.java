package design_pattern.strategy;

public class StrategyExample {

    public static void main(String[] args) {
        ConreteActioner actioner = new ConreteActioner();
        actioner.action.doIt();
    }
}

interface Action{
    void doIt();
}

abstract class AbstractActioner{
    Action action;

//    abstract void action();
}

class ConcreteAction implements Action{
    @Override
    public void doIt() {
        System.out.println("concrete action");
    }
}

class ConreteActioner extends AbstractActioner{
    public ConreteActioner() {
        action = new ConcreteAction();
    }
}
