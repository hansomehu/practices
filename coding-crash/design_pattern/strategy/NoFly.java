package design_pattern.strategy;

/**
 * @author hanson.hu
 */
public class NoFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i can not fly");
    }
}
