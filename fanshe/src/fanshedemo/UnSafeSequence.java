package fanshedemo;

public class UnSafeSequence {

    public class TestMath{

        private TestMath(){

            System.out.println("父类实例化");

        }

    }

    public class TestMath1 extends TestMath{

        public TestMath1(){

            System.out.println("子类实例化");

        }

    }

    /**

     * @param args

     */

    public static void main(String[] args) {

        System.out.println(new UnSafeSequence().new TestMath1());

    }

}
