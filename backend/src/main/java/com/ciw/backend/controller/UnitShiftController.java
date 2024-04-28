package com.ciw.backend.controller;

import com.ciw.backend.payload.MapResponseWithoutPage;
import com.ciw.backend.payload.SimpleResponse;
import com.ciw.backend.payload.unitshift.*;
import com.ciw.backend.service.UnitShiftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/unit/shift")
@RequiredArgsConstructor
@Tag(
		name = "Unit Shift"
)
@Validated
public class UnitShiftController {
	private final UnitShiftService unitShiftService;

	@GetMapping("/{id}")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Fetch unit shift by week",
			description = "Fetch unit shift by week from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	public ResponseEntity<UnitShiftResponse> getUnitShiftByWeek(@PathVariable Long id) {
		return new ResponseEntity<>(unitShiftService.fetchShiftByWeek(id), HttpStatus.OK);
	}

	@GetMapping("/day")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Fetch unit shift by day",
			description = "Fetch unit shift by day from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	public ResponseEntity<MapResponseWithoutPage<UnitShiftDayResponse, UnitShiftDayFilter>> getUnitShiftByDay(
			@Valid UnitShiftDayFilter filter) {
		return new ResponseEntity<>(unitShiftService.fetchShiftByDay(filter), HttpStatus.OK);
	}

	@PostMapping("/{id}")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Change unit shift",
			description = "Change unit shift"
	)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status is 201 CREATED"
	)
	public ResponseEntity<UnitShiftResponse> changeUnitShiftByWeek(
			@PathVariable Long id,
			@Valid ChangeUnitShiftRequest request) {
		return new ResponseEntity<>(unitShiftService.changeShift(id, request), HttpStatus.CREATED);
	}

	@PostMapping("/{id}/absent")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Absent unit shift",
			description = "Register to absent for unit"
	)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status is 201 CREATED"
	)
	public ResponseEntity<SimpleResponse> absentUnitShift(
			@PathVariable Long id,
			@Valid AbsentUnitShiftRequest request) {
		return new ResponseEntity<>(unitShiftService.absentUnitShift(id, request), HttpStatus.CREATED);
	}
}