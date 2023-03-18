package design_pattern.strategy;

public class StrategyMoreSimpleExample {
    public static void main(String[] args) {
        Actioner actioner1 = new Actioner(new ActionerOne());
        Actioner actioner2 = new Actioner(new ActionerTwo());

        actioner1.doIt();
        actioner2.doIt();
    }
}

interface Actions{
    void action();
}

class ActionerOne implements Actions{
    @Override
    public void action() {
        System.out.println("a1");
    }
}

class ActionerTwo implements Actions{
    @Override
    public void action() {
        System.out.println("a2");
    }
}

class Actioner{
    Actions actions;

    public Actioner(Actions actions) {
        this.actions = actions;
    }

    public void doIt(){
        actions.action();
    }
}
