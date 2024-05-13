package com.tmkt.tools;

public class TMVSortChecker {

    public TMVSortChecker() {}

    public boolean isSortedAscending(String[] values) {
        double[] numbers = extractNumbers(values);
        return isAscending(numbers);
    }

    public boolean isSortedDescending(String[] values) {
        double[] numbers = extractNumbers(values);
        return isDescending(numbers);
    }

    private double[] extractNumbers(String[] values) {
        double[] numbers = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            String value = values[i].replace("€", "").replace("m", "");
            numbers[i] = Double.parseDouble(value);
        }
        return numbers;
    }

    private boolean isAscending(double[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDescending(double[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
