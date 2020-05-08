import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://www.htl-leoben.at/";
        PhoneFinder pf = new PhoneFinder(url);
        List<String> ph = pf.getPhoneNumbers();
        System.out.println("URL: " + url);
        for (String p: ph) {
            System.out.println(p);
        }
    }
}
