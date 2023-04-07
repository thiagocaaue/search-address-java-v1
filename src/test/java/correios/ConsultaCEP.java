package correios;

import java.rmi.RemoteException;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

public class ConsultaCEP {

	public static void main(String[] args) {

		AtendeClienteProxy cliente = new AtendeClienteProxy();

		try {
			EnderecoERP endereco = cliente.consultaCEP("69313165");
			System.out.println("Endereço: " + endereco.getEnd());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Complemento: " + endereco.getComplemento2());
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Cidade: " + endereco.getCidade());
			System.out.println("UF: " + endereco.getUf());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
