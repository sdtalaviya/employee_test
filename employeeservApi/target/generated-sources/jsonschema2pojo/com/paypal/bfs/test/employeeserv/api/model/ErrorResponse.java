
package com.paypal.bfs.test.employeeserv.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Error Response on Failue
 * <p>
 * Error Response
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errors",
    "errorMessage"
})
public class ErrorResponse {

    /**
     * List of errors associated
     * 
     */
    @JsonProperty("errors")
    @JsonPropertyDescription("List of errors associated")
    @Valid
    private List<String> errors = new ArrayList<String>();
    /**
     * Error Message
     * 
     */
    @JsonProperty("errorMessage")
    @JsonPropertyDescription("Error Message")
    private String errorMessage;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * List of errors associated
     * 
     */
    @JsonProperty("errors")
    public List<String> getErrors() {
        return errors;
    }

    /**
     * List of errors associated
     * 
     */
    @JsonProperty("errors")
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    /**
     * Error Message
     * 
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Error Message
     * 
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ErrorResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("errors");
        sb.append('=');
        sb.append(((this.errors == null)?"<null>":this.errors));
        sb.append(',');
        sb.append("errorMessage");
        sb.append('=');
        sb.append(((this.errorMessage == null)?"<null>":this.errorMessage));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.errorMessage == null)? 0 :this.errorMessage.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.errors == null)? 0 :this.errors.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ErrorResponse) == false) {
            return false;
        }
        ErrorResponse rhs = ((ErrorResponse) other);
        return ((((this.errorMessage == rhs.errorMessage)||((this.errorMessage!= null)&&this.errorMessage.equals(rhs.errorMessage)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.errors == rhs.errors)||((this.errors!= null)&&this.errors.equals(rhs.errors))));
    }

}
