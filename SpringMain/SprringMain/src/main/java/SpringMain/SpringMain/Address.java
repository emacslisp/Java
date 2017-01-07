package SpringMain.SpringMain;

//@example: spring - dependency injection
public class Address {
	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}
	private String street;
	private String postcode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}
	
}
