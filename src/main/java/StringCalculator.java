public class StringCalculator {
    public String[] split(String text) {
        if (text == null) {
            return new String[]{};
        }
        return text.split("[,\n]");
    }

    public int[] toInt(String[] values) {
        if (values == null) {
            return new int[]{};
        }

        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    public int sumIntArr(int[] intArr) {
        if (intArr == null) {
            return 0;
        }

        int sum = 0;
        for (int i : intArr) {
            sum += i;
        }
        return sum;
    }

    public int calculate(String str) {
        String[] split = split(str);
        int[] ints = toInt(split);
        return sumIntArr(ints);
    }
}
