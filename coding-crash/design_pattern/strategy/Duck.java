package design_pattern.strategy;

/**
 * @author hanson.hu
 */
public abstract class Duck {

    /**
     * accessible under same pkg
      */
    FlyBehavior flyBehavior;

    public void fly(){
        flyBehavior.fly();
    }
}
