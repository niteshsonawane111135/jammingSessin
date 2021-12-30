package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
	int id;
	
	@Column(name = "street_address")
	String streetAddress;
	@Column(name = "postal_code")
	String postalCode;
	
	@ToString.Exclude
	@Column(name = "city")
	String city;
	@Column(name = "state_province")
	String stateProvince;
	@Column(name = "country_id")
	Long countryId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}
	
}
