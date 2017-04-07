package d0407;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ExceptionTest {
    public static void main(String[] args) {
//        exceptionTest();
        test1();
    }

    public static void exceptionTest() {
        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("操作出错，错误信息：");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally代码段");
        }

        /*
         Object x = new Integer(0);
         System.out.println((String) x);
       */

        System.out.println("这是一行测试代码");
    }


    public static void test1() {
        try {
            String[] ss = new String[3];
            ss[7] = "123";
        } catch (NegativeArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getCause());
            System.out.println("NegativeArraySizeException");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            System.out.println("RuntimeException");
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            System.out.println("Exception");
        } finally {
//            System.out.println("即使抛出异常，我也是必须执行的！");
        }
    }
}
