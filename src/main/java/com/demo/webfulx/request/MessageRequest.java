package com.demo.webfulx.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {

	@NotBlank(message = "El content no puede ser vacio")
    private String content;
	
	
    private LocalDateTime timestamp;
}
