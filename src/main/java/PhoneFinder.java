import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneFinder {
    private List<String> phoneNumbers = new ArrayList<String>();
    private String url;
    final String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    public PhoneFinder(String url) { this.url = url; }
    public List<String> getPhoneNumbers() throws IOException {
        exportPhoneNumbers();
        return phoneNumbers;
    }
    public String getUrl() { return url; }
    private void exportPhoneNumbers() throws IOException {
        Document doc = Jsoup.connect(this.url).get();
        Elements ps = doc.select("a");
        List<String> myParagraphs = ps.eachText();
        for(String s : myParagraphs) {
            Matcher m = Pattern.compile(this.regex).matcher(s);
            while (m.find()) {
                phoneNumbers.add(m.group());
            }
        }
    }
}
