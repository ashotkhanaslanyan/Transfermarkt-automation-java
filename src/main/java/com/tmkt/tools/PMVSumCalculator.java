package com.tmkt.tools;

public class PMVSumCalculator {

    public PMVSumCalculator() {}

    public Double getTMVFromPMVs(String[] values) {
        double[] numbers = extractNumbers(values);
        return calculateSumOfAllPMVs(numbers);
    }

    public double getTMVFromHeaderValues(String number) {
        return extractTeamMarketValue(number);
    }

    public int getSquadSize(String squadSize) {
        return Integer.parseInt(squadSize);
    }

    public int getPlayersRowCount(String[] rows) {
        return rows.length;
    }

    public double calculateSumOfAllPMVs(double[] numbers) {
        double sum = 0.0;
        for (double number :numbers) {
            sum += number;
        }
        return sum;
    }

    private double[] extractNumbers(String[] values) {
        double[] numbers = new double[values.length];
    
        for (int i = 0; i < values.length; i++) {
            String value = values[i].replace("€", "");
            double multiplier = 1.0;
            
            if (value.endsWith("m")) {
                multiplier = 1_000_000.0;
                value = value.substring(0, value.length() - 1);
            } else if (value.endsWith("k")) {
                multiplier = 1_000.0;
                value = value.substring(0, value.length() - 1);
            }
            
            numbers[i] = Double.parseDouble(value) * multiplier;
        }
        return numbers;
    }

    private double extractTeamMarketValue(String number) {
        String finalNumber = number.replace("€", ""); 
        finalNumber = finalNumber.replace("\"", "");
        finalNumber = finalNumber.replace("\nTotal market value", "");
        double multiplier = 1.0;

        if (finalNumber.endsWith("m")) {
            multiplier = 1_000_000.0;
            finalNumber = finalNumber.substring(0, finalNumber.length() - 1);
        } else if (finalNumber.endsWith("k")) {
            multiplier = 1_000.0;
            finalNumber = finalNumber.substring(0, finalNumber.length() - 1);
        } else if (finalNumber.endsWith("b")) {
            multiplier = 1_000_000_000.0;
            finalNumber = finalNumber.substring(0, finalNumber.length() - 1);
        }

        double TMV = Double.parseDouble(finalNumber) * multiplier;
        return TMV;
    }
}
