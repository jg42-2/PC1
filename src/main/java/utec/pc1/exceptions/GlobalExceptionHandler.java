package utec.pc1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler({StoreNotFoundException.class, ProductNotFoundException.class})
    public ProblemDetail handleNotFound(RuntimeException ex){
        return build(HttpStatus.NOT_FOUND, "Resource not found", ex.getMessage());
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    public ProblemDetail handleUnauthorized(RuntimeException ex){
        return build(HttpStatus.UNAUTHORIZED, "Unauthorized.", ex.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistsException.class, ProductNotAvailableException.class})
    public ProblemDetail handleConflict(RuntimeException ex){
        return build(HttpStatus.CONFLICT, "Conflict.", ex.getMessage());
    }

    @ExceptionHandler({ForbiddenStoreException.class})
    public ProblemDetail handleForbidden(RuntimeException ex){
        return build(HttpStatus.FORBIDDEN, "Resource not found", ex.getMessage());
    }
    private ProblemDetail build(HttpStatus status, String title, String detail) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, detail);
        pd.setTitle(title);
        return pd;
    }
}
