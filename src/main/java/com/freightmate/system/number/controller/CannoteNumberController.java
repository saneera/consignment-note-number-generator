package com.freightmate.system.number.controller;

import com.freightmate.system.number.dto.CannoteNumberDto;
import com.freightmate.system.number.service.CannoteNumberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
@Validated
public class CannoteNumberController {

    @Autowired
    private CannoteNumberService cannoteNumberService;

    @PostMapping("/generate-cannote-number")
    @Operation(
            summary = "Generate Cannote Number",
            description = "Returns the generated cannote  number")
    public String generateCannoteNumber(@Valid @RequestBody CannoteNumberDto cannoteNumber) {
        return cannoteNumberService.generateCannoteNumber(cannoteNumber);
    }
}
