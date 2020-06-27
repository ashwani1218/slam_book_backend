/**
 * 
 */
package com.ashwani.slambook.model.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.ashwani.slambook.entity.Slam;
import com.ashwani.slambook.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 25-Jun-2020
 *
*/
public class GetUserDetailsResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6676785595211557314L;

	
	private String firstname;
	
	private String lastname;
	
	private List<Slam> slams;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Slam> getSlams() {
		return slams;
	}

	public void setSlams(List<Slam> slams) {
		this.slams = slams;
	}

	public GetUserDetailsResponse(HttpStatus httpStatus, String status, String responseCode, String note,
			String responseDescription, String firstname, String lastname, List<Slam> slams) {
		super(httpStatus, status, responseCode, note, responseDescription);
		this.firstname = firstname;
		this.lastname = lastname;
		this.slams = slams;
	}

	public GetUserDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUserDetailsResponse(HttpStatus httpStatus, String status, String responseCode, String note,
			String responseDescription) {
		super(httpStatus, status, responseCode, note, responseDescription);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GetUserDetailsResponse [firstname=" + firstname + ", lastname=" + lastname + ", slams=" + slams + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((slams == null) ? 0 : slams.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetUserDetailsResponse other = (GetUserDetailsResponse) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (slams == null) {
			if (other.slams != null)
				return false;
		} else if (!slams.equals(other.slams))
			return false;
		return true;
	}
	
	
}
