package com.freightmate.system.number.service;


import com.freightmate.system.exception.BadRequestException;
import com.freightmate.system.number.dto.CannoteNumberDto;
import com.freightmate.system.number.util.CannoteNumberUtil;
import org.springframework.stereotype.Service;

@Service
public class CannoteNumberService {

    public String generateCannoteNumber(CannoteNumberDto cannoteNumber) {
        validateDto(cannoteNumber);
        return CannoteNumberUtil.buildCannoteNumberNumber(cannoteNumber);
    }

    private void validateDto(CannoteNumberDto cannoteNumber) {
        if (cannoteNumber.getRangeStart() > cannoteNumber.getLastUsedIndex()) {
            throw new BadRequestException("lastIndexUsed is greater than or equal to rangeStart");

        } else  if (cannoteNumber.getLastUsedIndex() >= cannoteNumber.getRangeEnd()) {
            throw new BadRequestException("lastIndexUsed is less than to rangeStart");
        }
    }
}
