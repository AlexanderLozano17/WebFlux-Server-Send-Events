package com.demo.webfulx.usecase;

import org.springframework.http.codec.ServerSentEvent;

import com.demo.webfulx.request.MessageRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageUseCase {

	Mono<Void> send(String content);
	
	Flux<ServerSentEvent<MessageRequest>> stream();
	
}
