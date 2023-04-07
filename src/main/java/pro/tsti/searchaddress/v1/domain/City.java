package pro.tsti.searchaddress.v1.domain;

import java.io.Serializable;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long citId;
	private String name;
	private String state;

	public City() {

	}

	public City(String name, String state) {
		this.name = name;
		this.state = state;
	}

	public Long getCitId() {
		return citId;
	}

	public void setCitId(Long citId) {
		this.citId = citId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
