package com.ashwani.slambook.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.ashwani.slambook.constants.JsonConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7326098745541028052L;

	@JsonIgnore
	private HttpStatus httpStatus;
	
	@JsonProperty(JsonConstants.BASE_RESPONSE_STATUS)
	private String Status;
	
	
	@JsonProperty(JsonConstants.BASE_RESPONSE_CODE)
	private String responseCode;
	
	
	@JsonProperty(JsonConstants.BASE_RESPONSE_DESCRIPTION)
	private String responseDescription;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	
	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	@Override
	public String toString() {
		return "LoginResponse [httpStatus=" + httpStatus + ", Status=" + Status + ", responseCode=" + responseCode
				+ ", responseDescription=" + responseDescription + "]";
	}

	public BaseResponse(HttpStatus httpStatus, String status, String responseCode, String note,
			String responseDescription) {
		super();
		this.httpStatus = httpStatus;
		Status = status;
		this.responseCode = responseCode;
		
		this.responseDescription = responseDescription;
	}

	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((httpStatus == null) ? 0 : httpStatus.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((responseDescription == null) ? 0 : responseDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseResponse other = (BaseResponse) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (httpStatus != other.httpStatus)
			return false;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (responseDescription == null) {
			if (other.responseDescription != null)
				return false;
		} else if (!responseDescription.equals(other.responseDescription))
			return false;
		return true;
	}


	
	
	
}
