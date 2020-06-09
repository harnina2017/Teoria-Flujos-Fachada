package modelo.acceso;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.GrabadorAleatorio;
import modelo.acceso.grabador.GrabadorBinario;
import modelo.acceso.grabador.GrabadorTexto;
import modelo.acceso.recuperador.RecuperadorAleatorio;
import modelo.acceso.recuperador.RecuperadorBinario;
import modelo.acceso.recuperador.RecuperadorTexto;
import modelo.dao.ArticuloDAO;
import modelo.dao.ClienteAleatorioDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.SocioDAO;
import modelo.dto.ArticuloDTO;
import modelo.dto.ClienteDTO;
import modelo.dto.SocioDTO;

public class Fachada {
	private String pathCliente = "./cliente.cli";
//	private String pathArticulo = "./articulo.cli";
//	private String pathSocio = " ";
	private ClienteAleatorioDAO<ClienteDTO, Integer> clienteAleatorioDAO;
//	private ArticuloDAO articuloDAO;
//	private SocioDAO socioDAO;

	public Fachada() {
		super();
		//clienteDAO = new ClienteDAO(new RecuperadorBinario(), new GrabadorBinario(), pathCliente);
		clienteAleatorioDAO = new ClienteAleatorioDAO<ClienteDTO, Integer> (new RecuperadorAleatorio<ClienteDTO, Integer>(), 
				new GrabadorAleatorio<ClienteDTO,Integer>(), pathCliente);
//		articuloDAO = new ArticuloDAO(new RecuperadorTexto(), new GrabadorTexto(), pathArticulo);
//		socioDAO = new SocioDAO(new RecuperadorAleatorio(), new GrabadorAleatorio(), pathSocio);
		
	}

	public boolean graba(ClienteDTO cliente) {
		return clienteAleatorioDAO.graba(cliente);
	}

//	public boolean graba(ArticuloDTO articulo) {
//		return articuloDAO.graba(articulo);
//	}
//
//	public boolean graba(SocioDTO socio) {
//		return socioDAO.graba(socio);
//	}

	public ArrayList<ClienteDTO> leerClientes() throws IOException {
		return clienteAleatorioDAO.recupera();
	}
	
	public ClienteDTO leerCliente(Integer integer) {
		return clienteAleatorioDAO.recupera(integer);
	}

//	public ArrayList<ArticuloDTO> leerArticulos() throws IOException {
//		return articuloDAO.recupera();
//
//	}
//
//	public ArrayList<SocioDTO> leersocios() throws IOException {
//		return socioDAO.recupera();
//
//	}

}
