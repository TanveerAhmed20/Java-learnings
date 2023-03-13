@FunctionalInterface
interface A{
    // public void m1();
    // public void m2();
    public void show();
}
class B implements A{
    public void show(){
        System.out.println("inside");
    }
}
public class Demo{
    public static void main(String args[]){
        A obj = new B(){
            public void show(){
                System.out.println("inshow");
            }
        };
        obj.show();
    }
}