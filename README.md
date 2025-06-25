# 📡 Spring WebFlux - SSE (Server-Sent Events)

Este proyecto es un ejemplo funcional de cómo implementar **Server-Sent Events (SSE)** usando **Spring Boot WebFlux**.  
Permite que el servidor envíe eventos en tiempo real a los clientes conectados, útil para notificaciones, dashboards, monitoreo, etc.

---

## 🧱 Tecnologías usadas

- Java 17+
- Spring Boot 3+
- Spring WebFlux
- Server-Sent Events (SSE)
- Project Reactor (Flux / Mono)

---

## ⚙️ Estructura del proyecto

- `MessageRequest` → DTO para los mensajes enviados.
- `MessageService` → Administra los mensajes y el canal SSE.
- `MessageController` → Expone los endpoints REST y SSE.

---

## ▶️ Cómo ejecutar

### 1. Clona el repositorio

```bash
git clone https://github.com/AlexanderLozano17/WebFlux-Server-Send-Events.git
```

