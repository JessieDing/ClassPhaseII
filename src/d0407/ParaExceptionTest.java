package d0407;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ParaExceptionTest {
    public static void main(String[] args) {
        try {
            testMyException();
        } catch (ParaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testMyException() throws Exception {
        int a = 2;
        if (a > 0 && a < 5) {
            throw new ParaException();
        }
    }
}

class ParaException extends Exception {
    private static final long serialVersionUID = 1L;

    public ParaException() {
        super();
    }

    public ParaException(String message) {
        super(message);
    }

    public ParaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParaException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return "传入参数有误";
    }
}
