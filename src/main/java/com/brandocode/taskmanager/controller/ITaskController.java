package com.brandocode.taskmanager.controller;

import com.brandocode.taskmanager.controller.to.ResponseTO;
import com.brandocode.taskmanager.controller.to.TaskTO;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/v1/tasks")
public interface ITaskController {

    String APPLICATION_JSON = "application/json";

    @ApiResponses(value={
            @ApiResponse(responseCode = "202", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @Operation(summary = "Finds all tasks")
    @GetMapping(produces = APPLICATION_JSON)
    ResponseEntity<?> getTasks();

    @ApiResponses(value={
            @ApiResponse(responseCode = "202", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @Operation(summary = "Creates a new task")
    @PostMapping( consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    ResponseEntity<ResponseTO> createTask(@ApiParam(value = "Task to create", required = true) @Valid @RequestBody TaskTO task);

    @ApiResponses(value={
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @Operation(summary = "Updates an existing task")
    @PutMapping(value = "/update", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    ResponseEntity<ResponseTO> updateTask(@ApiParam(value = "Task to update", required = true) @Valid @RequestBody TaskTO task);

    @ApiResponses(value={
            @ApiResponse(responseCode = "202", description = "Deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    @Operation(summary = "Deletes an existing task")
    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> deleteTask(@ApiParam(value = "Task to delete") @PathVariable("id") Long id);
}
