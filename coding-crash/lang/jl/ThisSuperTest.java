package lang.jl;

public class ThisSuperTest {
    public void a(){

    }

    public ThisSuperTest(String txt) {
        System.out.println(txt);
    }

    /*
    this调构造方法、成员变量、成员方法
     */
    public void b(){
        this.a();
    }
}
