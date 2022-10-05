package com.freightmate.system.number.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CannoteNumberDto implements Serializable {

    @NotNull
    private String carrierName;
    @NotNull
    private String accountNumber;
    @NotNull
    private Integer digits;
    @NotNull
    private Integer lastUsedIndex;
    @NotNull
    private Integer rangeStart;
    @NotNull
    private Integer rangeEnd;

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public Integer getLastUsedIndex() {
        return lastUsedIndex;
    }

    public void setLastUsedIndex(Integer lastUsedIndex) {
        this.lastUsedIndex = lastUsedIndex;
    }

    public Integer getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(Integer rangeStart) {
        this.rangeStart = rangeStart;
    }

    public Integer getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(Integer rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
