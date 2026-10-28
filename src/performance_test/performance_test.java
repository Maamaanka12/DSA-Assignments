//package performance_test;
//
//public class performance_test {
//
//        // Number of times we repeat the reversal to get a reliable measurement
//        private static final int ITERATIONS = 10000;
//
//        // The text we will reverse
//        private static final String ORIGINAL_TEXT =
//                "The quick brown fox jumps over the lazy dog while the sun sets slowly behind the mountains";
//
//        public static void main(String[] args) {
//
//            System.out.println("Original text:");
//            System.out.println(ORIGINAL_TEXT);
//            System.out.println("Length: " + ORIGINAL_TEXT.length() + " characters");
//            System.out.println("Iterations per test: " + ITERATIONS);
//            System.out.println();
//
//            // ---------------------------------------------------------------
//            // PART 1: HAND-MADE REVERSAL (manual loop, no built-in reverse)
//            // ---------------------------------------------------------------
//
//            // --- String (immutable, manual) ---
//            long stringManualStart = System.nanoTime();
//            String stringManualResult = "";
//            for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//                stringManualResult = reverseUsingStringManually(ORIGINAL_TEXT);
//            }
//            long stringManualEnd = System.nanoTime();
//            long stringManualTime = stringManualEnd - stringManualStart;
//
//            // --- StringBuffer (manual) ---
//            long stringBufferManualStart = System.nanoTime();
//            String stringBufferManualResult = "";
//            for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//                stringBufferManualResult = reverseUsingStringBufferManually(ORIGINAL_TEXT);
//            }
//            long stringBufferManualEnd = System.nanoTime();
//            long stringBufferManualTime = stringBufferManualEnd - stringBufferManualStart;
//
//            // --- StringBuilder (manual) ---
//            long stringBuilderManualStart = System.nanoTime();
//            String stringBuilderManualResult = "";
//            for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//                stringBuilderManualResult = reverseUsingStringBuilderManually(ORIGINAL_TEXT);
//            }
//            long stringBuilderManualEnd = System.nanoTime();
//            long stringBuilderManualTime = stringBuilderManualEnd - stringBuilderManualStart;
//
//            // ---------------------------------------------------------------
//            // PART 2: BUILT-IN REVERSAL (using .reverse() method)
//            // ---------------------------------------------------------------
//
//            // --- StringBuffer (built-in) ---
//            long stringBufferBuiltInStart = System.nanoTime();
//            String stringBufferBuiltInResult = "";
//            for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//                stringBufferBuiltInResult = reverseUsingStringBufferBuiltIn(ORIGINAL_TEXT);
//            }
//            long stringBufferBuiltInEnd = System.nanoTime();
//            long stringBufferBuiltInTime = stringBufferBuiltInEnd - stringBufferBuiltInStart;
//
//            // --- StringBuilder (built-in) ---
//            long stringBuilderBuiltInStart = System.nanoTime();
//            String stringBuilderBuiltInResult = "";
//            for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//                stringBuilderBuiltInResult = reverseUsingStringBuilderBuiltIn(ORIGINAL_TEXT);
//            }
//            long stringBuilderBuiltInEnd = System.nanoTime();
//            long stringBuilderBuiltInTime = stringBuilderBuiltInEnd - stringBuilderBuiltInStart;
//
//            // ---------------------------------------------------------------
//            // PRINT RESULTS
//            // ---------------------------------------------------------------
//
//            System.out.println("Reversed text (all methods produce same result):");
//            System.out.println(stringManualResult);
//            System.out.println();
//
//            System.out.println("--- HAND-MADE REVERSAL (manual loop) ---");
//            System.out.println("String       : " + stringManualTime + " ns");
//            System.out.println("StringBuffer : " + stringBufferManualTime + " ns");
//            System.out.println("StringBuilder: " + stringBuilderManualTime + " ns");
//            System.out.println();
//
//            System.out.println("--- BUILT-IN REVERSAL (.reverse()) ---");
//            System.out.println("StringBuffer : " + stringBufferBuiltInTime + " ns");
//            System.out.println("StringBuilder: " + stringBuilderBuiltInTime + " ns");
//            System.out.println();
//
//            // ---------------------------------------------------------------
//            // WINNER SUMMARY
//            // ---------------------------------------------------------------
//
//            System.out.println("--- FASTEST IN EACH CATEGORY ---");
//            System.out.println("Hand-made fastest   : " + findFastest(
//                    "String", stringManualTime,
//                    "StringBuffer", stringBufferManualTime,
//                    "StringBuilder", stringBuilderManualTime));
//            System.out.println("Built-in fastest    : " + findFastest(
//                    "StringBuffer", stringBufferBuiltInTime,
//                    "StringBuilder", stringBuilderBuiltInTime,
//                    "StringBuilder", stringBuilderBuiltInTime));
//        }
//
//        // ===================================================================
//        // HAND-MADE REVERSAL METHODS (no built-in reverse)
//        // ===================================================================
//
//        /**
//         * Reverses a string using plain String concatenation.
//         * This is SLOW because each "+" creates a new String object.
//         */
//        private static String reverseUsingStringManually(String input) {
//            String reversed = "";
//            for (int index = input.length() - 1; index >= 0; index--) {
//                reversed = reversed + input.charAt(index);
//            }
//            return reversed;
//        }
//
//        /**
//         * Reverses a string using StringBuffer.append() in a manual loop.
//         */
//        private static String reverseUsingStringBufferManually(String input) {
//            StringBuffer buffer = new StringBuffer();
//            for (int index = input.length() - 1; index >= 0; index--) {
//                buffer.append(input.charAt(index));
//            }
//            return buffer.toString();
//        }
//
//        /**
//         * Reverses a string using StringBuilder.append() in a manual loop.
//         */
//        private static String reverseUsingStringBuilderManually(String input) {
//            StringBuilder builder = new StringBuilder();
//            for (int index = input.length() - 1; index >= 0; index--) {
//                builder.append(input.charAt(index));
//            }
//            return builder.toString();
//        }
//
//        // ===================================================================
//        // BUILT-IN REVERSAL METHODS (using .reverse())
//        // ===================================================================
//
//        private static String reverseUsingStringBufferBuiltIn(String input) {
//            return new StringBuffer(input).reverse().toString();
//        }
//
//        private static String reverseUsingStringBuilderBuiltIn(String input) {
//            return new StringBuilder(input).reverse().toString();
//        }
//
//        // ===================================================================
//        // Helper: find the fastest among 3 (name, time) pairs
//        // ===================================================================
//        private static String findFastest(String nameOne, long timeOne,
//                                          String nameTwo, long timeTwo,
//                                          String nameThree, long timeThree) {
//            String fastestName = nameOne;
//            long fastestTime = timeOne;
//
//            if (timeTwo < fastestTime) {
//                fastestName = nameTwo;
//                fastestTime = timeTwo;
//            }
//            if (timeThree < fastestTime) {
//                fastestName = nameThree;
//                fastestTime = timeThree;
//            }
//            return fastestName + " (" + fastestTime + " ns)";
//        }
//    }

//}

package performance_test;

import java.util.Stack;

public class performance_test {

    private static final String ORIGINAL_TEXT =
            "The quick brown fox jumps over the lazy dog while the sun sets slowly behind the mountains";

    public static void main(String[] args) {

        System.out.println("Original text:");
        System.out.println(ORIGINAL_TEXT);
        System.out.println("Length: " + ORIGINAL_TEXT.length() + " characters");
        System.out.println();

        // ---------------------------------------------------------------
        // PART 1: HAND-MADE REVERSAL (Stack push/pop)
        // ---------------------------------------------------------------

        long stringManualStart = System.nanoTime();
        String stringManualResult = reverseUsingStringManually(ORIGINAL_TEXT);
        long stringManualEnd = System.nanoTime();
        long stringManualTime = stringManualEnd - stringManualStart;

        long stringBufferManualStart = System.nanoTime();
        String stringBufferManualResult = reverseUsingStringBufferManually(ORIGINAL_TEXT);
        long stringBufferManualEnd = System.nanoTime();
        long stringBufferManualTime = stringBufferManualEnd - stringBufferManualStart;

        long stringBuilderManualStart = System.nanoTime();
        String stringBuilderManualResult = reverseUsingStringBuilderManually(ORIGINAL_TEXT);
        long stringBuilderManualEnd = System.nanoTime();
        long stringBuilderManualTime = stringBuilderManualEnd - stringBuilderManualStart;

        // ---------------------------------------------------------------
        // PART 2: BUILT-IN REVERSAL (using .reverse())
        // ---------------------------------------------------------------

        long stringBufferBuiltInStart = System.nanoTime();
        String stringBufferBuiltInResult = reverseUsingStringBufferBuiltIn(ORIGINAL_TEXT);
        long stringBufferBuiltInEnd = System.nanoTime();
        long stringBufferBuiltInTime = stringBufferBuiltInEnd - stringBufferBuiltInStart;

        long stringBuilderBuiltInStart = System.nanoTime();
        String stringBuilderBuiltInResult = reverseUsingStringBuilderBuiltIn(ORIGINAL_TEXT);
        long stringBuilderBuiltInEnd = System.nanoTime();
        long stringBuilderBuiltInTime = stringBuilderBuiltInEnd - stringBuilderBuiltInStart;

        // ---------------------------------------------------------------
        // PRINT RESULTS
        // ---------------------------------------------------------------

        System.out.println("Reversed text (all methods produce same result):");
        System.out.println(stringManualResult);
        System.out.println();

        System.out.println("--- HAND-MADE REVERSAL (Stack push/pop) ---");
        System.out.println("String       : " + stringManualTime + " ns");
        System.out.println("StringBuffer : " + stringBufferManualTime + " ns");
        System.out.println("StringBuilder: " + stringBuilderManualTime + " ns");
        System.out.println();

        System.out.println("--- BUILT-IN REVERSAL (.reverse()) ---");
        System.out.println("StringBuffer : " + stringBufferBuiltInTime + " ns");
        System.out.println("StringBuilder: " + stringBuilderBuiltInTime + " ns");
        System.out.println();

        // ---------------------------------------------------------------
        // WINNER SUMMARY
        // ---------------------------------------------------------------

        System.out.println("--- FASTEST IN EACH CATEGORY ---");
        System.out.println("Hand-made fastest   : " + findFastest(
                "String", stringManualTime,
                "StringBuffer", stringBufferManualTime,
                "StringBuilder", stringBuilderManualTime));
        System.out.println("Built-in fastest    : " + findFastest(
                "StringBuffer", stringBufferBuiltInTime,
                "StringBuilder", stringBuilderBuiltInTime));
    }

    // ===================================================================
    // HAND-MADE REVERSAL METHODS (Stack push/pop)
    // ===================================================================

    private static String reverseUsingStringManually(String input) {
        Stack<Character> characterStack = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            characterStack.push(input.charAt(index));
        }

        String reversed = "";
        while (!characterStack.isEmpty()) {
            reversed = reversed + characterStack.pop();
        }
        return reversed;
    }

    private static String reverseUsingStringBufferManually(String input) {
        Stack<Character> characterStack = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            characterStack.push(input.charAt(index));
        }

        StringBuffer reversed = new StringBuffer();
        while (!characterStack.isEmpty()) {
            reversed.append(characterStack.pop());
        }
        return reversed.toString();
    }

    private static String reverseUsingStringBuilderManually(String input) {
        Stack<Character> characterStack = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            characterStack.push(input.charAt(index));
        }

        StringBuilder reversed = new StringBuilder();
        while (!characterStack.isEmpty()) {
            reversed.append(characterStack.pop());
        }
        return reversed.toString();
    }

    // ===================================================================
    // BUILT-IN REVERSAL METHODS (using .reverse())
    // ===================================================================

    private static String reverseUsingStringBufferBuiltIn(String input) {
        return new StringBuffer(input).reverse().toString();
    }

    private static String reverseUsingStringBuilderBuiltIn(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // ===================================================================
    // Helper: find the fastest among 3 (name, time) pairs
    // ===================================================================
    private static String findFastest(String nameOne, long timeOne,
                                      String nameTwo, long timeTwo,
                                      String nameThree, long timeThree) {
        String fastestName = nameOne;
        long fastestTime = timeOne;

        if (timeTwo < fastestTime) {
            fastestName = nameTwo;
            fastestTime = timeTwo;
        }
        if (timeThree < fastestTime) {
            fastestName = nameThree;
            fastestTime = timeThree;
        }
        return fastestName + " (" + fastestTime + " ns)";
    }

    // ===================================================================
    // Helper: find the fastest between 2 (name, time) pairs
    // ===================================================================
    private static String findFastest(String nameOne, long timeOne,
                                      String nameTwo, long timeTwo) {
        if (timeTwo < timeOne) {
            return nameTwo + " (" + timeTwo + " ns)";
        }
        return nameOne + " (" + timeOne + " ns)";
    }
}