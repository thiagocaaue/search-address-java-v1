package pro.tsti.searchaddress.v1.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pro.tsti.searchaddress.v1.domain.Address;
import pro.tsti.searchaddress.v1.service.AddressService;

@Named
@ViewScoped
public class AddressView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Address address;
	private String postalCode;

	@Inject
	private AddressService service;

	@PostConstruct
	public void init() {
		address = new Address();
	}

	public void searchPostalCode() {

		if (this.postalCode != null && !this.postalCode.isEmpty()) {

			this.address = service.searchPostalCode(this.postalCode);

			if (!this.address.getPublicName().equals("NOT FOUND")) {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CEP encontrado com Sucesso"));

			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "CEP inválido"));
			}

		}

		PrimeFaces.current().ajax().update("form:message");
		PrimeFaces.current().ajax().update("form");

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
