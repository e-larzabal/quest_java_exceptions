import java.sql.SQLOutput;
import java.util.ArrayList;
import java.lang.Exception;

public class OddSum {

    public static void main(String[] args) {
        run(args, false);
    }

    public static int run(String[] args, boolean test) {

        ArrayList<Integer> listInt = new ArrayList<>();
        int res=0;

        try {
            if (!test) {
                System.out.println("Elements' list :");
                for (String v : args)
                    System.out.print(" " + v);
                System.out.println();
            }
            for (int i = 0; i < args.length; i++) {
                listInt.add(Integer.parseInt(args[i]));
            }
            res = sum(listInt);
            if (test) { return res; }
        } catch ( NullPointerException e ) {
            System.err.println("-------------------------------------------------");
            System.err.println("Error in Run method : NullPointerException");
            System.err.println("Error message:"+e.getMessage());
            System.err.println("Error trace:"+printStackTrace(e));
            System.err.println("-------------------------------------------------");
            return -1;
        } catch ( NumberFormatException e) {
            System.err.println("-------------------------------------------------");
            System.err.println("Error in Run method : NumberFormatException");
            System.err.println("Error message:"+e.getMessage());
            System.err.println("Error trace:"+printStackTrace(e));
            System.err.println("-------------------------------------------------");
            return -1;
        } catch ( Exception e ) {
            System.err.println("-------------------------------------------------");
            System.err.println("Error in Run method : Exception");
            System.err.println("Error message:"+e.getMessage());
            System.err.println("Error trace:"+printStackTrace(e));
            System.err.println("-------------------------------------------------");
            return -1;
        } finally {
            System.out.println("Sum of odd elements : " + res);
            System.out.println("END!");
        }

        return 0;
    }

    public static int sum(ArrayList<Integer> listInt) {

        int result = 0;
        for (int value : listInt) {
            if (value % 2 != 0) {
                result += value;
            }
        }
        return result;
    }

    public static String printStackTrace(Exception e){
        String trace="";
        StackTraceElement elements[] = e.getStackTrace();
        for (int i=0 ; i<elements.length ; i++){
            trace += elements[i].getFileName()+":"+elements[i].getLineNumber()+">> "+elements[i].getMethodName()+"()";
            if (i<elements.length-1) { trace += "\n"; }
        }
        return trace;
    }

}
