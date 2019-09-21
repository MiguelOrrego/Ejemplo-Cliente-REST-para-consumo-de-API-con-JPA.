package com.ecodeup.ws.rest.client;
import javax.swing.*;

import com.ecodeup.model.Libro;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class AppRest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int opcion = 0;
	ServicioCliente servicio;
	Libro libro;
	String menu="1.Registrar Libro\n";
	menu+="2.Editar Libro \n";
	menu+="3.Eliminar Libro \n";
	menu+="4.Buscar Libro \n";
	menu+="5.Salir \n";
	menu+="Elija Una Opcion \n";


	while (opcion!=5) {
		opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));

		switch (opcion) {
		case 1:
			servicio=new ServicioCliente();
			 libro= new Libro();
			 libro.setId(0);
			 libro.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del libro"));
			 libro.setAutor(JOptionPane.showInputDialog("Ingrese el autor del libro"));
			 libro.setEdicion(JOptionPane.showInputDialog("Ingrese el año de edicion del libro"));
			servicio.obtenerServicioCliente("registrarLibros",libro);
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			System.out.println();
			break;
			
		case 2:
			servicio=new ServicioCliente();
			 libro= new Libro();
			 libro.setId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que desea actualizar")));
			 libro.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del libro"));
			 libro.setAutor(JOptionPane.showInputDialog("Ingrese el autor del libro"));
			 libro.setEdicion(JOptionPane.showInputDialog("Ingrese el año de edicion del libro"));
			 servicio.obtenerServicioCliente("editarLibros",libro);
			System.out.println();
			break;
			
		case 3:
			servicio=new ServicioCliente();
			 libro= new Libro();

			 libro.setId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que desea eliminar")));
			 servicio.obtenerServicioCliente("eliminarLibros",libro);

			System.out.println();
			break;
			
		case 4:
			servicio=new ServicioCliente();
			 libro= new Libro();
			 libro.setId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que desea Consultar")));
			 servicio.obtenerServicioCliente("buscarLibros",libro);

			System.out.println();
			break;		
		case 5:JOptionPane.showMessageDialog(null, "Haz Salido");;
		break;

		default:
			JOptionPane.showMessageDialog(null,"Opción no válida\n");
			break;
		}
}
}
}