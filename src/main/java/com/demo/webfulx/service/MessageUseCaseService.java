package com.demo.webfulx.service;

import java.time.LocalDateTime;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.demo.webfulx.request.MessageRequest;
import com.demo.webfulx.usecase.MessageUseCase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class MessageUseCaseService implements MessageUseCase {

	// Sink que permite emitir mensajes a múltiples suscriptores (multicast)
	private final Sinks.Many<MessageRequest> sink;
	
	public MessageUseCaseService() {
		// onBackpressureBuffer: evita que los suscriptores pierdan eventos si no consumen a tiempo
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
	}
	
	/**
	 * Envía un nuevo mensaje al flujo SSE.
	 * 
	 * @param content El contenido del mensaje
	 * @return Mono<Void> que representa la finalización del proceso
	 */
	@Override
	public Mono<Void> send(String content) {

		MessageRequest message = new MessageRequest(content, LocalDateTime.now());
		sink.tryEmitNext(message); // Emite el mensaje a todos los suscriptores conectados
        return Mono.empty(); // No retorna valor, solo ejecuta acción
	}

	/**
	 * Devuelve un flujo de Server-Sent Events para que el cliente lo consuma.
	 * 
	 * @return Flux de ServerSentEvent con objetos Message
	 */
	@Override
	public Flux<ServerSentEvent<MessageRequest>> stream() {
		return sink.asFlux()
				.map(msg -> ServerSentEvent.builder(msg).build());
	}

	
}
