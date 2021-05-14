
package com.paypal.bfs.test.employeeserv.api.model;

import java.util.HashMap;
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
 * Employee DOB
 * <p>
 * Date of Birth
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "month",
    "year"
})
public class DateOfBirth {

    /**
     * Day
     * 
     */
    @JsonProperty("date")
    @JsonPropertyDescription("Day")
    private Integer date;
    /**
     * Month
     * 
     */
    @JsonProperty("month")
    @JsonPropertyDescription("Month")
    private Integer month;
    /**
     * Year
     * 
     */
    @JsonProperty("year")
    @JsonPropertyDescription("Year")
    private Integer year;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Day
     * 
     */
    @JsonProperty("date")
    public Integer getDate() {
        return date;
    }

    /**
     * Day
     * 
     */
    @JsonProperty("date")
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * Month
     * 
     */
    @JsonProperty("month")
    public Integer getMonth() {
        return month;
    }

    /**
     * Month
     * 
     */
    @JsonProperty("month")
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * Year
     * 
     */
    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    /**
     * Year
     * 
     */
    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
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
        sb.append(DateOfBirth.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("month");
        sb.append('=');
        sb.append(((this.month == null)?"<null>":this.month));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null)?"<null>":this.year));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.month == null)? 0 :this.month.hashCode()));
        result = ((result* 31)+((this.year == null)? 0 :this.year.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DateOfBirth) == false) {
            return false;
        }
        DateOfBirth rhs = ((DateOfBirth) other);
        return (((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.month == rhs.month)||((this.month!= null)&&this.month.equals(rhs.month))))&&((this.year == rhs.year)||((this.year!= null)&&this.year.equals(rhs.year))));
    }

}
