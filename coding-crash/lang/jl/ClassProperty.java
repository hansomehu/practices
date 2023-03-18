package lang.jl;

public class ClassProperty {

    /*
    final class 这种就无法被代理
     */
    final class TestA{
        void a(){

        }
    }

    /*
    the proxy object cannot access to method b()
     */
    class TestB{
        private void b(){

        }
    }
}
