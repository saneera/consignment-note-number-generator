package com.freightmate.system.util;

import com.freightmate.system.TestHelper;
import com.freightmate.system.number.dto.CannoteNumberDto;
import com.freightmate.system.number.util.CannoteNumberUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CannoteNumberUtilTest {

    @Test
    void testCannotNumberGenerator (){
       CannoteNumberDto connateNumberDto1 = TestHelper.buildConnateNumberDto(19604);
       assertEquals("FMCC123ABC00000196051", CannoteNumberUtil.buildCannoteNumberNumber(connateNumberDto1));
       CannoteNumberDto connateNumberDto2 = TestHelper.buildConnateNumberDto(19605);
       assertEquals("FMCC123ABC00000196068", CannoteNumberUtil.buildCannoteNumberNumber(connateNumberDto2));
    }

    @Test
    void testCheckSum (){
        assertEquals(1, CannoteNumberUtil.calculateCheckSum("0000019605"));
        assertEquals(8, CannoteNumberUtil.calculateCheckSum("0000019606"));
        assertEquals(5, CannoteNumberUtil.calculateCheckSum("0000019607"));
    }

}
