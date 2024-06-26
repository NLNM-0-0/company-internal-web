package com.ciw.backend.controller;

import com.ciw.backend.payload.ListResponse;
import com.ciw.backend.payload.SimpleResponse;
import com.ciw.backend.payload.page.AppPageRequest;
import com.ciw.backend.payload.unit.*;
import com.ciw.backend.service.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/unit")
@RequiredArgsConstructor
@Tag(
		name = "Unit"
)
@Validated
public class UnitController {
	private final UnitService unitService;

	@GetMapping
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Fetch units",
			description = "Note:\n" +
						  "- Fetch all unit except admin unit"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	public ResponseEntity<ListResponse<UnitWithManagerNumStaffResponse, UnitFilter>> getUnits(
			@Valid AppPageRequest page,
			@Valid UnitFilter filter) {
		return new ResponseEntity<>(unitService.getUnits(page, filter), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Fetch detail unit",
			description = "Note:\n" +
						  "- Can not reach admin unit"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	public ResponseEntity<UnitResponse> getUnit(@PathVariable Long id) {
		return new ResponseEntity<>(unitService.getUnit(id), HttpStatus.OK);
	}

	@PostMapping
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Create unit",
			description = "Note:\n" +
						  "- Can not create unit with ADMIN feature"
	)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status is 201 CREATED"
	)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<UnitResponse> createUnit(
			@Valid @RequestBody CreateUnitRequest request
	) {
		return new ResponseEntity<>(unitService.createUnit(request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Update unit",
			description = "Note:\n" +
						  "- Can not reach admin unit\n" +
						  "- Can not make unit has feature ADMIN"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<UnitWithManagerNumStaffResponse> updateUnit(
			@PathVariable Long id,
			@Valid @RequestBody UpdateUnitRequest request
	) {
		return new ResponseEntity<>(unitService.updateUnit(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@Operation(
			summary = "Delete unit",
			description = "Note:\n" +
						  "- Can not reach admin unit"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status is 200 OK"
	)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<SimpleResponse> deleteUnit(
			@PathVariable Long id
	) {
		return new ResponseEntity<>(unitService.deleteUnit(id), HttpStatus.OK);
	}

}
