public class RabinKarp {
    public static final int PRIME = 101;

    public static void main(String[] args) {
        String text = "cxyzghxyzvjkxyz";
        String pattern = "xyz";

        searchPattern(text, pattern);
    }

    public static void searchPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int patternHash = hash(pattern, patternLength);
        int textHash = hash(text.substring(0, patternLength), patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash) {
                int j = 0;
                while (j < patternLength && text.charAt(i + j) == pattern.charAt(j)) {
                    j++;
                }
                if (j == patternLength) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, textHash, i, i + patternLength);
            }
        }
    }

    public static int hash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * PRIME + str.charAt(i)) % PRIME;
        }
        return hash;
    }

    public static int recalculateHash(String text, int oldHash, int oldIndex, int newIndex) {
        int newHash = (oldHash - text.charAt(oldIndex) * (int) Math.pow(PRIME, 0)) % PRIME;
        newHash = (newHash * PRIME + text.charAt(newIndex)) % PRIME;
        return (newHash < 0) ? newHash + PRIME : newHash;
    }
}
