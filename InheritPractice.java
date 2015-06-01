public class InheritPractice {

    public static void main(String[] args) {
        //thread
    }
}
class Base{
    void myfunc(){
        System.out.println("All your base are belong to us");
        
    }
}

class Parent {
    class Member {
        
    }
    public void func2(){
        new Base(){
            void myfunc(){
                System.out.println("Let's get FUNCy");
            }
        }.myfunc();
        //made nameless class, defined func, called the func. override
        new Object(){
            void someFunc(){
                
            }
        }.someFunc();
    }
    public void func(){
        class Inner{
            
        }
    }
}
