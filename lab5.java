import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nnums");
        nums("The .3 price of 11 the 15. product is $19.99 v.11.a .16.9.");
        System.out.println("\npassword");
        password("0123456789abcdef");
        System.out.println("\nhyperlink");
        hyperlink("aaaa.ru hhgkh.com hghjgj.kz");
        System.out.println("\nip");
        ip("0.99.0.99");
        System.out.println("\nwords");
        words('n', "n Na ngdjfkjn nffsfnsfs nfdsf8k rrrr");
    }
    public static void nums(String text) {
        Pattern pattern = Pattern.compile("(\\d+\\.)?\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    public static void password(String text) {
        Pattern pattern09 = Pattern.compile("\\d");
        Pattern patternAZ = Pattern.compile("[A-Z]");
        Pattern patternNo = Pattern.compile("[^\\w]");
        Matcher matcherAZ = patternAZ.matcher(text);
        boolean AZ = matcherAZ.find();
        Matcher matcher09 = pattern09.matcher(text);
        boolean thereAre09 = matcher09.find();
        Matcher matcherNo = patternNo.matcher(text);
        boolean no = !matcherNo.find();
        boolean l = (8 <= text.length()) && (text.length() <= 16);
        if (AZ && thereAre09 && no && l){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
    public static void hyperlink(String text){
        Pattern pattern = Pattern.compile("[A-Za-z]+\\.[A-Za-z]+((/[A-Za-z])+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String link = matcher.group();
            text = text.replaceAll(link, "https://www."+link);
        }
        System.out.println(text);
    }
    public static void ip(String text) {
        Pattern pattern = Pattern.compile("^((2[0-5][0-5]|1\\d{2}|\\d{2}|\\d{1})\\.)((2[0-5][0-5]|1(\\d{2})|\\d{2}|\\d{1})\\.)((2[0-5][0-5]|1(\\d{2})|\\d{2}|\\d{1})\\.)(2[0-5][0-5]|1(\\d{2})|\\d{2}|\\d{1})$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
    public static void words(char letter, String text){
        Pattern pattern = Pattern.compile(String.format("\\b%s[a-z]*\\b", letter), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
