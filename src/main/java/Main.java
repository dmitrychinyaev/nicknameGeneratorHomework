import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger beautyLength3 = new AtomicInteger();
    public static AtomicInteger beautyLength4 = new AtomicInteger();
    public static AtomicInteger beautyLength5 = new AtomicInteger();

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        BeautyChecker beautyChecker = new BeautyChecker();

        new Thread(() -> {
            for (String text : texts) {
                if (beautyChecker.isPalindrome(text)) {
                    switch (text.length()) {
                        case 3 -> beautyLength3.incrementAndGet();
                        case 4 -> beautyLength4.incrementAndGet();
                        case 5 -> beautyLength5.incrementAndGet();
                        default -> {
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            for (String text : texts) {
                if (beautyChecker.isOneLetter(text)) {
                    switch (text.length()) {
                        case 3 -> beautyLength3.incrementAndGet();
                        case 4 -> beautyLength4.incrementAndGet();
                        case 5 -> beautyLength5.incrementAndGet();
                        default -> {
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            for (String text : texts) {
                if (beautyChecker.isOrderCorrect(text)) {
                    switch (text.length()) {
                        case 3 -> beautyLength3.incrementAndGet();
                        case 4 -> beautyLength4.incrementAndGet();
                        case 5 -> beautyLength5.incrementAndGet();
                        default -> {
                        }
                    }
                }
            }
        }).start();

        System.out.println("Красивых слов с длиной 3: " + beautyLength3);
        System.out.println("Красивых слов с длиной 4: " + beautyLength4);
        System.out.println("Красивых слов с длиной 5: " + beautyLength5);

    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
