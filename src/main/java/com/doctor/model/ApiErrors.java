package com.doctor.model;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors{            //ApiErrors Class for showing global exceptions
	LocalDateTime timestap;
	String message;
	int status;
	String error;
}
