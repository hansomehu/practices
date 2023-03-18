package lang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyCGLib {

    /*
    JDK代理在调用方法的时候走的是反射
    CGLib走的是FastClass机制，也是生成类
    二者都是通过字节码去生成类，前者是Class后者是ASM

    所以当我们调用query()方法时，先是调用到$Proxy0.query()方法，在这个方法中，直接调用了super.h.invoke()方法，
    父类是Proxy，父类中的h就是我们定义的InvocationHandler，所以这儿会调用到UserServiceInvocationHandler.invoke()方法；
    因此当我们通过代理对象去执行目标对象的方法时，
    会先经过InvocationHandler的invoke()方法，
    然后在通过反射method.invoke()去调用目标对象的方法，
    因此每次都会先打印invocation handler这句话；

    https://blog.csdn.net/jiankunking/article/details/52143504

    使用JDK动态代理，目标类必须实现的某个接口，如果某个类没有实现接口则不能生成代理对象。
    Cglib原理是针对目标类生成一个子类，覆盖其中的所有方法，所以目标类和方法不能声明为final类型。
     */

    public interface Biz{

        public String SayHello(String name);

        public String SayGoodBye();
    }

    public class RealImpl implements Biz{

        @Override
        public String SayHello(String name) {
            return null;
        }

        @Override
        public String SayGoodBye() {
            return null;
        }
    }

    public class InvocationHandlerImpl implements InvocationHandler{
        private Object target;

        public InvocationHandlerImpl(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    public void main(String[] args) {
        RealImpl real = new RealImpl();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(real);

        ClassLoader classLoader = real.getClass().getClassLoader();
        Class<?>[] interfaces = real.getClass().getInterfaces();

        Object proxyO = (RealImpl) Proxy.newProxyInstance(classLoader, interfaces, handler);



    }

}
