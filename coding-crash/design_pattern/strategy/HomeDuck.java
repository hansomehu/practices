package design_pattern.strategy;

/**
 * @author hanson.hu
 */
public class HomeDuck extends Duck {

    public HomeDuck(){
        flyBehavior = new NoFly();
    }

    public static void main(String[] args) {
        HomeDuck homeDuck = new HomeDuck();
        homeDuck.fly();
    }

}
