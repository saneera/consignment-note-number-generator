package com.freightmate.system;

import com.freightmate.system.number.dto.CannoteNumberDto;

public class TestHelper {

    public static CannoteNumberDto buildConnateNumberDto(Integer lastIndexUsed) {
        CannoteNumberDto connateNumberDto = new CannoteNumberDto();
        connateNumberDto.setCarrierName("FreightmateCourierCo");
        connateNumberDto.setAccountNumber("123ABC");
        connateNumberDto.setDigits(10);
        connateNumberDto.setLastUsedIndex(lastIndexUsed);
        connateNumberDto.setRangeStart(19000);
        connateNumberDto.setRangeEnd(20000);
        return connateNumberDto;
    }
}
