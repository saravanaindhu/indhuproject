package com.movie.manager.util;

import com.movie.manager.model.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public <T> ResponseEntity<RestResponse<T>> defaultErrorResponse() {
        final RestResponse<T> responseTemplate = this.buildResponseTemplate(false, null, "");

        return new ResponseEntity<>(responseTemplate, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public <T> ResponseEntity<RestResponse<T>> buildErrorResponse(final HttpStatus errorResponseCode,
            final String responseMessage) {
        final RestResponse<T> responseTemplate = this.buildResponseTemplate(false, null, responseMessage);

        return new ResponseEntity<>(responseTemplate, errorResponseCode);
    }

    public <T> ResponseEntity<RestResponse<T>> buildResponse(final T responseObject, final HttpStatus responseCode,
            final String responseMessage) {
        final RestResponse<T> responseTemplate = this
                .buildResponseTemplate(responseCode.is2xxSuccessful(), responseObject, responseMessage);

        return new ResponseEntity<>(responseTemplate, responseCode);
    }

    private <T> RestResponse<T> buildResponseTemplate(final boolean successFlag, final T responseObject,
            final String responseMessage) {
        final RestResponse<T> restResponse = new RestResponse();
        restResponse.setSuccess(successFlag);
        restResponse.setMessage(responseMessage);
        restResponse.setData(responseObject);

        return restResponse;

    }
}

