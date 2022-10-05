package com.freightmate.system.number.util;

import com.freightmate.system.number.dto.CannoteNumberDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.freightmate.system.number.util.Constant.DEFAULT_PREFIX;

public class CannoteNumberUtil {

    public static String paddingWithZero(String inputString, int paddedLength) {
        return "0".repeat(paddedLength - inputString.length())+ inputString;
    }

    public static Integer calculateCheckSum(String input) {
        List<Integer> digits = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> listSwap = IntStream.rangeClosed(1, digits.size())
                .mapToObj(i -> digits.get(digits.size() - i))
                .collect(Collectors.toList());

        List<Integer> eventList = IntStream
                .range(0, listSwap.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> listSwap.get(i))
                .collect(Collectors.toList());

        List<Integer> oddList = IntStream
                .range(0, listSwap.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> listSwap.get(i))
                .collect(Collectors.toList());

        Integer oddCount = oddList.stream().collect(Collectors.summingInt(Integer::intValue))*7;
        Integer eventCount = eventList.stream().collect(Collectors.summingInt(Integer::intValue)) *3;

        Integer sumOfTwo = oddCount+ eventCount;

        return  getNextMultipleOfTen(sumOfTwo) - sumOfTwo;
    }


    public static Integer getNextIndexedToUse(Integer lastIndexUsed) {
        return ++lastIndexUsed;
    }

    public static Integer getNextMultipleOfTen(Integer n) {
        if (n % 10 != 0) {
            return n + (10 - n % 10);
        } else {
            return n;
        }
    }

    public static String buildCannoteNumberNumber(CannoteNumberDto cannoteNumber) {
        Integer nextIndexToUse = getNextIndexedToUse(cannoteNumber.getLastUsedIndex());
        System.out.println(nextIndexToUse);
        String paddedString =  paddingWithZero(String.valueOf(nextIndexToUse), cannoteNumber.getDigits());
        System.out.println(paddedString);
        Integer checkSumValue = calculateCheckSum(paddedString);
        System.out.println(checkSumValue);
        return DEFAULT_PREFIX+ cannoteNumber.getAccountNumber()+""+paddedString+checkSumValue;

    }
}
