package com.demo.webfulx.controller;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webfulx.request.MessageRequest;
import com.demo.webfulx.usecase.MessageUseCase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

/**
 * Controlador REST que expone los endpoints para enviar mensajes
 * y suscribirse a flujos de mensajes vía SSE.
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

	private final MessageUseCase service;
	
	public MessageController(MessageUseCase service) {
		this.service = service;
	}
	
	@PostMapping
	public Mono<Void> send(@Validated @RequestBody MessageRequest request) {
	
		return service.send(request.getContent());
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<MessageRequest>> stream() {
		return service.stream();
	}
}
