package design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hanson.hu
 */
public class JDKProxyFactory {

    public JDKProxyFactory(ITeacher teacherOrigin) {
        this.teacherOrigin = teacherOrigin;
    }

    private ITeacher teacherOrigin;

    public Object genTeacherProxy(){
        return Proxy.newProxyInstance(
                ITeacher.class.getClassLoader(),
                ITeacher.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("pre process");
                        Object o = method.invoke(proxy, args);
                        System.out.println("post  process");

                        return o;
                    }
                }
        );
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        // compulsory transform
        Teacher teacherProxy = (Teacher) new JDKProxyFactory(teacher).genTeacherProxy();
        teacherProxy.teach();

    }


}
