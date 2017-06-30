/**
 * Created by Administrator on 2017/6/15.
 */
public class TestSpilt {
    public static void main(String[] args) {
        String str = "root.";
        String string = "root";
        String[] strings = str.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println(str.trim().split("\\.").length);

        if (string.contains(".") && str.trim().equals(string.substring(0, string.lastIndexOf(".")))) {
            System.out.println("haschild");
        }
        if (str.contains(".") && str.substring(0, str.lastIndexOf(".")).equals(string)) {
            System.out.println("hasparent");
        }
    }
}
