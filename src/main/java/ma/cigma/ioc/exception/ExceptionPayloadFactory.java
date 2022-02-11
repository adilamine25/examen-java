package ma.cigma.ioc.exception;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public enum ExceptionPayloadFactory {
    UNKNOWN_ERROR(1000, "unknown.error", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    USER_NOT_FOUND(1001, "user.not.found", HttpStatus.BAD_REQUEST.value()),
    ;
    private ExceptionPayload exceptionPayload;

    ExceptionPayloadFactory(final Integer code, final String message, final Integer statusCode) {
        this.exceptionPayload = ExceptionPayload.builder()
                .code(code)
                .message(message)
                .statusCode(statusCode)
                .build();
    }

    public ExceptionPayload get() {
        return exceptionPayload.toBuilder()
                .timestamp(LocalDateTime.now())
                .build();
    }
}
