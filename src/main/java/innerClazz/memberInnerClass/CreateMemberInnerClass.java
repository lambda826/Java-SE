package innerClazz.memberInnerClass;

public class CreateMemberInnerClass {

    public static void main(String[] args) {
        CreateMemberInnerClass dn = new CreateMemberInnerClass();
        // Creating an inner class directly using the .new syntax.
        CreateMemberInnerClass.Inner dni = dn.new Inner();

    }

    public class Inner {
    }
} 
