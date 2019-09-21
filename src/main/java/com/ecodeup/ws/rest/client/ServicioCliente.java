package com.ecodeup.ws.rest.client;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.ecodeup.model.JPAUtil;
import com.ecodeup.model.Libro;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
public class ServicioCliente {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public  void obtenerServicioCliente(String funcion, Libro libros){
		if(funcion.equals("registrarLibros")) {
		String urlServicio="http://localhost:8080/CRUD_API_REST_JPA/servicio/PruebaOrrego/"+funcion;
		System.out.println("Servicio:" + urlServicio);
		
		ClientConfig clienteConfig=new DefaultClientConfig();
		clienteConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client cliente=Client.create(clienteConfig);
		
		WebResource webResource=cliente.resource(urlServicio);
		
		ClientResponse respuesta=webResource.type("application/json").post(ClientResponse.class,libros);

		}else {
			if(funcion.equals("editarLibros")){
				System.out.println(libros.getId());
				Object rs = entity.find(Libro.class, libros.getId());
				if(rs!=null){
				String urlServicio="http://localhost:8080/CRUD_API_REST_JPA/servicio/PruebaOrrego/"+funcion;
				System.out.println("Servicio:" + urlServicio);
					
				ClientConfig clienteConfig=new DefaultClientConfig();
				clienteConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
					
				Client cliente=Client.create(clienteConfig);
				WebResource webResource=cliente.resource(urlServicio);
				ClientResponse respuesta=webResource.type("application/json").put(ClientResponse.class,libros);
				 JOptionPane.showMessageDialog(null, "se actualizo Exitosamente");
				}else{
	
					 JOptionPane.showMessageDialog(null, "el id del libro no existe");
				}
				
			}else{
				if(funcion.equals("eliminarLibros")){
					System.out.println(libros.getId());
					Object rs = entity.find(Libro.class, libros.getId());
					if(rs!=null){
					 String urlServicio="http://localhost:8080/CRUD_API_REST_JPA/servicio/PruebaOrrego/eliminarLibros/"+libros.getId();
						System.out.println("Servicio:" + urlServicio);
						
						ClientConfig clienteConfig=new DefaultClientConfig();
						clienteConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
						
						Client cliente=Client.create(clienteConfig);
						
						WebResource webResource=cliente.resource(urlServicio);
						ClientResponse respuesta=webResource.type("application/json").delete(ClientResponse.class,libros.getId());
						 JOptionPane.showMessageDialog(null, "se elimino Exitosamente");
					}else{
						 JOptionPane.showMessageDialog(null, "el id del libro no existe");
					}
				}else{
					if(funcion.equals("buscarLibros")){
						System.out.println(libros.getId());
						Object rs = entity.find(Libro.class, libros.getId());
						if(rs!=null){
						 String urlServicio="http://localhost:8080/CRUD_API_REST_JPA/servicio/PruebaOrrego/buscarLibros/"+libros.getId();
							System.out.println("Servicio:" + urlServicio);
							
							ClientConfig clienteConfig=new DefaultClientConfig();
							clienteConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
							
							Client cliente=Client.create(clienteConfig);
							
							WebResource webResource=cliente.resource(urlServicio);
							ClientResponse respuesta=webResource.type("application/json").get(ClientResponse.class);
							libros=respuesta.getEntity(Libro.class);
							 JOptionPane.showMessageDialog(null, "\n ID:"+libros.getId()+"\n NOMBRE:"+libros.getNombre()+"\n AUTOR:"+libros.getAutor()
									 						+ "\n AÑO DE EDICION:"+libros.getEdicion());
						}else{
							 JOptionPane.showMessageDialog(null, "el id del libro no existe");
						}
					}
				}
			}
		}
	}
	}

