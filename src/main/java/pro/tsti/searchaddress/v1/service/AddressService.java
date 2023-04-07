package pro.tsti.searchaddress.v1.service;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.enterprise.context.ApplicationScoped;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import pro.tsti.searchaddress.v1.domain.Address;
import pro.tsti.searchaddress.v1.domain.City;

@ApplicationScoped
public class AddressService implements Serializable {

	private static final long serialVersionUID = 1L;

	private Address address;

	public Address searchPostalCode(String postalCode) {
		
		this.address = new Address();

		AtendeClienteProxy client = new AtendeClienteProxy();

		try {

			EnderecoERP response = client.consultaCEP(postalCode);

			if (response != null) {
				
				String placeType = response.getEnd().substring(0, response.getEnd().indexOf(" "));
				String publicName = response.getEnd().substring(response.getEnd().indexOf(" ") + 1, response.getEnd().length());

				address.setPlaceType(placeType);
				address.setPublicName(publicName);
				address.setDistrict(response.getBairro());
				address.setPostalCode(response.getCep());
				address.setCity(new City(response.getCidade(), response.getUf()));

				return address;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		address.setPublicName("NOT FOUND");

		return address;

	}

}
