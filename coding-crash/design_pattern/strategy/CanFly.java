package design_pattern.strategy;

/**
 * @author hanson.hu
 */
public class CanFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
