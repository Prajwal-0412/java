package com.simple.employee.exception;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	private boolean isError;
	private String errMessage;
	private Object object;

}
