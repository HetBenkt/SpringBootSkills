package nl.bos.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such ProductList")
public class ProductListNotFoundException extends RuntimeException {

}
