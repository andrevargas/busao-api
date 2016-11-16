
package br.univali.sisnet.api.error;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class ErrorMessage {

    private final int statusCode;
    private final String statusMessage;
    private final String errorMessage;

    public ErrorMessage(int statusCode, String statusMessage, String errorMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
