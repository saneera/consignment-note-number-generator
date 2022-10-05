package com.freightmate.system.number.service;


import com.freightmate.system.number.dto.CannoteNumberDto;
import com.freightmate.system.number.util.CannoteNumberUtil;
import org.springframework.stereotype.Service;

@Service
public class CannoteNumberService {

    public String generateCannoteNumber(CannoteNumberDto cannoteNumber) {
        return CannoteNumberUtil.buildCannoteNumberNumber(cannoteNumber);
    }
}
