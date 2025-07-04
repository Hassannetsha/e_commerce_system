public class Utilities {
    private static final int totalWidth = 40;

    public static String calculatePadding(String... items) {
        int usedWidth = 0;
        for (String item : items) {
            usedWidth += item.length();
        }
        int spaces = totalWidth - usedWidth;
        if (spaces < 1)
            spaces = 1;
        return " ".repeat(spaces);
    }

}
