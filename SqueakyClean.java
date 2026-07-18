import java.util.ArrayList;
import java.util.List;

class SqueakyClean {
    static String clean(String identifier) {
        char[] chars = identifier.toCharArray();
        List<Character> cleanedChars = new ArrayList<>();
        boolean capitalizeNext = false;
        for (char c : chars) {
            if (c == ' ') {
                cleanedChars.add('_');
                continue;
            } else if (c == '-') {
                capitalizeNext = true;
                continue;
            } else if (c == '4'){
                cleanedChars.add('a');
            } else if (c == '3'){
                cleanedChars.add('e');
            } else if (c == '0'){
                cleanedChars.add('o');
            } else if (c == '1'){
                cleanedChars.add('l');
            } else if (c == '7'){
                cleanedChars.add('t');
            } else if (Character.isLetter(c)) {
                cleanedChars.add(capitalizeNext ? Character.toUpperCase(c) : c);
            }
            capitalizeNext = false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : cleanedChars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(SqueakyClean.clean("my   Id"));
        System.out.println(SqueakyClean.clean("a-bc"));
        System.out.println(SqueakyClean.clean("H3ll0 W0rld"));
        System.out.println(SqueakyClean.clean("4 73s7"));
        System.out.println(SqueakyClean.clean("a$#.b"));
    }
}
