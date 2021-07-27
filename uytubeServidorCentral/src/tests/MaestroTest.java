package tests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import datatypes.DataCanal;
import datatypes.DataCategoria;
import datatypes.DataComentario;
import datatypes.DataComentarios;
import datatypes.DataIngresoComentario;
import datatypes.DataLista;
import datatypes.DataPair;
import datatypes.DataUsuario;
import datatypes.DataVideo;
import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import excepciones.PrivacidadInvalidaException;
import excepciones.RedundanciaException;
import logica.Fabrica;
import logica.IControlador;

public class MaestroTest {
	
	private IControlador iCon = Fabrica.getInstancia().getIControlador();
	private DataUsuario dataU1;
	private DataUsuario dataU2;
	private DataUsuario dataU3;
	private DataUsuario dataU4;
	private DataVideo dataV1;
	private DataVideo dataV2;
	private DataVideo dataV3;
	private DataIngresoComentario dataCom1;
	private DataIngresoComentario dataCom2;
	private DataIngresoComentario dataCom3;
	private DataIngresoComentario dataCom4;
	private DataIngresoComentario dataCom5;
	private DataIngresoComentario dataCom6;
	private LocalDateTime fechaCom1;
	private LocalDateTime fechaCom2;
	private LocalDateTime fechaCom3;
	private LocalDateTime fechaCom4;
	private LocalDateTime fechaCom5;
	private LocalDateTime fechaCom6;
	
	@Before
	public void init() {
		dataU1 = new DataUsuario();
		dataU1.setNickname("nick1");
		dataU1.setPassword("pass1");
		dataU1.setNombre("nom1");
		dataU1.setApellido("ape1");
		dataU1.setCorreo("cor1");
		dataU1.setImagen("img1");
		LocalDate fecha1 = LocalDate.of(2001, 01, 01);
		dataU1.setFechaNac(fecha1);
		DataCanal dataC1 = new DataCanal();
		dataC1.setNombre("nomC1");
		dataC1.setDescripcion("desc1");
		dataC1.setCategoria("cat1");
		dataC1.setPrivado(true);
		dataU1.setCanal(dataC1);
		
		dataU2 = new DataUsuario();
		dataU2.setNickname("nick2");
		dataU2.setPassword("pass2");
		dataU2.setNombre("nom2");
		dataU2.setApellido("ape2");
		dataU2.setCorreo("cor2");
		dataU2.setImagen("img2");
		LocalDate fecha2 = LocalDate.of(2002, 02, 02);
		dataU2.setFechaNac(fecha2);
		DataCanal dataC2 = new DataCanal();
		dataC2.setNombre("nomC2");
		dataC2.setDescripcion("desc2");
		//no tiene categoria
		dataC2.setPrivado(false);
		dataU2.setCanal(dataC2);
		
		dataU3 = new DataUsuario();
		dataU3.setNickname("nick3");
		dataU3.setPassword("pass3");
		dataU3.setNombre("nom3");
		dataU3.setApellido("ape3");
		dataU3.setCorreo("cor3");
		dataU3.setImagen("img3");
		LocalDate fecha3 = LocalDate.of(2003, 03, 03);
		dataU3.setFechaNac(fecha3);
		DataCanal dataC3 = new DataCanal();
		dataC3.setNombre("nomC3");
		dataC3.setDescripcion("desc3");
		//no tiene categoria
		dataC3.setPrivado(true);
		dataU3.setCanal(dataC3);
		
		dataU4 = new DataUsuario();
		dataU4.setNickname("nick4");
		dataU4.setPassword("pass4");
		dataU4.setNombre("nom4");
		dataU4.setApellido("ape4");
		dataU4.setCorreo("cor2");
		dataU4.setImagen("img4");
		LocalDate fecha4 = LocalDate.of(2004, 04, 04);
		dataU4.setFechaNac(fecha4);
		DataCanal dataC4 = new DataCanal();
		dataC4.setNombre("nomC4");
		dataC4.setDescripcion("desc4");
		//no tiene categoria
		dataC4.setPrivado(true);
		dataU4.setCanal(dataC4);
		
		dataV1 = new DataVideo();
		dataV1.setNombre("vid1");
		dataV1.setDescripcion("descV1");
		dataV1.setDuracion("dur1");
		dataV1.setUrl("url1");
		dataV1.setCategoria("cat1");
		dataV1.setPrivado(true);
		LocalDate fechaV1 = LocalDate.of(2011, 11, 11);
		dataV1.setFechaPub(fechaV1);
		
		dataV2 = new DataVideo();
		dataV2.setNombre("vid2");
		dataV2.setDescripcion("descV2");
		dataV2.setDuracion("dur2");
		dataV2.setUrl("url2");
		//no tiene categoria
		dataV2.setPrivado(false);
		LocalDate fechaV2 = LocalDate.of(2022, 12, 22);
		dataV2.setFechaPub(fechaV2);
		
		dataV3 = new DataVideo();
		dataV3.setNombre("vid2");
		dataV3.setDescripcion("descV3");
		dataV3.setDuracion("dur3");
		dataV3.setUrl("url3");
		dataV3.setCategoria("cat1");
		dataV3.setPrivado(true);
		LocalDate fechaV3 = LocalDate.of(2033, 10, 13);
		dataV3.setFechaPub(fechaV3);
		
		dataCom1 = new DataIngresoComentario();
		dataCom1.setTexto("Com1");
		fechaCom1 = LocalDateTime.now();
		dataCom1.setFecha(fechaCom1);
		
		dataCom2 = new DataIngresoComentario();
		dataCom2.setTexto("Com2");
		fechaCom2 = LocalDateTime.now();
		dataCom2.setFecha(fechaCom2);
		Integer[] rutaCom2 = new Integer[1];
		rutaCom2[0] = 2;
		dataCom2.setComentarioPadre(rutaCom2);
		
		dataCom3 = new DataIngresoComentario();
		dataCom3.setTexto("Com3");
		fechaCom3 = LocalDateTime.now();
		dataCom3.setFecha(fechaCom3);

		dataCom4 = new DataIngresoComentario();
		dataCom4.setTexto("Com4");
		fechaCom4 = LocalDateTime.now();
		dataCom4.setFecha(fechaCom4);
		Integer[] rutaCom4 = new Integer[2];
		rutaCom4[0] = 2;
		rutaCom4[1] = 2;
		dataCom4.setComentarioPadre(rutaCom4);
		
		dataCom5 = new DataIngresoComentario();
		dataCom5.setTexto("Com5");
		fechaCom5 = LocalDateTime.now();
		dataCom5.setFecha(fechaCom5);
		Integer[] rutaCom5 = new Integer[1];
		rutaCom5[0] = 2;
		dataCom5.setComentarioPadre(rutaCom5);
		
		fechaCom6 = LocalDateTime.now();
		dataCom6 = new DataIngresoComentario(fechaCom6, "Com6", "2.1.1");

	}
	
	@Test
	public void test() {
		
		//Usuario repetido
		try {
			iCon.confirmarAltaDeUsuario(dataU3);
			iCon.confirmarAltaDeUsuario(dataU3);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("Ya existe un usuario llamado nick3"));
		}
		
		//Lista Particular repetida
		try {
			iCon.confirmarCrearListaP("nick3", "listaP1", true);
			iCon.confirmarCrearListaP("nick3", "listaP1", true);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("El usuario nick3 ya tiene una lista llamada listaP1"));
		}
		
		//Lista Particular privacidad invalida
		try {
			iCon.confirmarCrearListaP("nick3", "listaP2", false);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("La lista no puede ser publica en un canal privado"));
		}
		
		//CatListaDefecto lista repetida
		try {
			iCon.confirmarCrearListaD("listaP1");
		} catch (NombreRepetidoException e) {
			assertTrue(e.getMessage().equals("El usuario nick3 ya tiene una lista llamada listaP1"));
		}
		
		//CatListaDefecto repetida
		try {
			iCon.confirmarCrearListaD("listaD1");
			iCon.confirmarCrearListaD("listaD2");
			iCon.confirmarCrearListaD("listaD1");
		} catch (NombreRepetidoException e) {
			assertTrue(e.getMessage().equals("La Lista Defecto listaD1 ya existe"));
		}
	
		//Categoria no existe al crear usuario
		try {
			iCon.confirmarAltaDeUsuario(dataU1);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("La categoria cat1 no existe"));
		}
		
		//Usuario no existe al crear video
		try {
			iCon.confirmarAltaDeVideo("nick1", dataV1);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 no existe"));
		}
		
		//Categoria no existe al crear video
		try {
			iCon.confirmarAltaDeVideo("nick3", dataV1);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("La categoria cat1 no existe"));
		}
		
		//Correo repetido
		try {
			iCon.confirmarAltaDeUsuario(dataU2);
			iCon.confirmarAltaDeUsuario(dataU4);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("Ya existe un usuario con el correo cor2"));
		}
		
		//Arranca Usuario 4
		try {
			dataU4.setCorreo("cor4");
			iCon.confirmarAltaDeUsuario(dataU4);
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra nunca"));
		}
		
		//Otra Lista P
		try {
			iCon.confirmarCrearListaP("nick2", "listaP2", true);
			iCon.confirmarCrearListaP("nick2", "listaP3", true);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("No entro a este assert"));
		}
		
		//Obtener listas particulares
		try {
			Set<String> setListasP = iCon.getListasParticulares("nick2");
			Integer nlisP = setListasP.size();
			assertTrue(nlisP.equals(2));
			assertTrue(setListasP.contains("listaP2"));
			assertTrue(setListasP.contains("listaP3"));
			iCon.getListasParticulares("noExiste");
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("El usuario noExiste no existe"));
		}
		
		
		//Alta de categorias
		try {
			iCon.confirmarAltaDeCategoria("cat1");
			iCon.confirmarAltaDeUsuario(dataU1);
			iCon.confirmarAltaDeCategoria("cat2");
			iCon.confirmarAltaDeCategoria("cat1");
		} catch (NombreRepetidoException|NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("La categoria cat1 ya existe"));
		}
	
		//Listado de categorias
		Set<String> setCats = iCon.getCategorias();
		Integer ncats = setCats.size();
		assertTrue(ncats.equals(2));
		assertTrue(setCats.contains("cat1"));
		assertTrue(setCats.contains("cat2"));
		
		//Listado de nicknames
		Set<String> setNicks = iCon.buscarUsuarios("");
		Integer nnicks = setNicks.size();
		assertTrue(nnicks.equals(4));
		assertTrue(setNicks.contains("nick1"));
		assertTrue(setNicks.contains("nick2"));
		assertTrue(setNicks.contains("nick3"));
		assertTrue(setNicks.contains("nick4"));
		
		//Nombre de video repetido
		try {
			iCon.confirmarAltaDeVideo("nick1", dataV3);
			iCon.confirmarAltaDeVideo("nick1", dataV1);
			iCon.confirmarAltaDeVideo("nick2", dataV2);
			iCon.confirmarAltaDeVideo("nick1", dataV1);
		} catch (NoExisteInstanciaException|NombreRepetidoException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 ya tiene un video llamado vid1"));
		}
		
		//Redundancia seguir
		try {
			iCon.confirmarSeguirUsuario("nick1", "nick2");
			iCon.confirmarSeguirUsuario("nick1", "nick2");
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 ya esta siguiendo a nick2"));
		}
		
		//Redundancia seguir
		try {
			iCon.confirmarNoSeguirUsuario("nick1", "nick2");
			iCon.confirmarNoSeguirUsuario("nick1", "nick2");
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 no esta siguiendo a nick2"));
		}
		
		//Valorar ya no gusta
		try {
			iCon.confirmarValorarVideo("nick2", "vid2", "nick1", true);
			iCon.confirmarValorarVideo("nick2", "vid2", "nick1", false);
			iCon.confirmarValorarVideo("nick2", "vid2", "nick1", false);
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("Al usuario nick1 ya no le gusta este video"));
		}
		
		//Valorar ya gusta
		try {
			iCon.confirmarValorarVideo("nick2", "vid2", "nick3", true);
			iCon.confirmarValorarVideo("nick1", "vid1", "nick3", true);
			iCon.confirmarValorarVideo("nick1", "vid1", "nick3", true);
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("Al usuario nick3 ya le gusta este video"));
		}
		
		//Valorar no existe video
		try {
			iCon.confirmarValorarVideo("nick1", "noExiste", "nick3", true);
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 no tiene un video llamado noExiste"));
		}
		
		//Comentar
		try {
			iCon.confirmarComentarVideo("nick1", "vid1", "nick2", dataCom1);
			iCon.confirmarComentarVideo("nick1", "vid1", "nick3", dataCom2);
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("Ruta no valida. No se encontro el comentario padre"));
		}
		
		//Comentar 2
		try {
			iCon.confirmarComentarVideo("nick1", "vid1", "nick1", dataCom3);
			iCon.confirmarComentarVideo("nick1", "vid1", "nick3", dataCom2);
			iCon.confirmarComentarVideo("nick1", "vid1", "nick4", dataCom4);
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("Ruta no valida. No se encontro el comentario padre"));
		}
		
		//Comentar 3
		try {
			Integer[] rutaCom4aux = new Integer[2];
			rutaCom4aux[0] = 2;
			rutaCom4aux[1] = 1;
			dataCom4.setComentarioPadre(rutaCom4aux);
			iCon.confirmarComentarVideo("nick1", "vid1", "nick4", dataCom4);
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra en este assert"));
		}
		
		//Comentar 4
		try {
			iCon.confirmarComentarVideo("nick1", "vid1", "nick2", dataCom5);
			iCon.confirmarComentarVideo("nick1", "vid1", "nick4", dataCom6);
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra en este assert"));
		}
		
		//Agregar y quitar video
		try {
			iCon.confirmarAgregarVideo("nick1", "vid1", "nick2", "listaD1");
			iCon.confirmarAgregarVideo("nick2", "vid2", "nick2", "listaP2");
			iCon.confirmarQuitarVideo("nick2", "vid2", "nick2", "listaP2");
			iCon.confirmarAgregarVideo("nick2", "vid2", "nick2", "listaP2");
			iCon.confirmarQuitarVideo("nick1", "vid1", "nick2", "listaD1");
			iCon.confirmarQuitarVideo("nick1", "vid1", "nick2", "listaD1");
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("La lista ya no contiene este video"));
		}
		
		//Agregar y quitar video 2
		try {
			iCon.confirmarAgregarVideo("nick1", "vid1", "nick2", "listaP2");
			iCon.confirmarAgregarVideo("nick1", "vid1", "nick2", "listaD1");
			iCon.confirmarAgregarVideo("nick2", "vid2", "nick2", "listaP2");
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("La lista ya contiene este video"));
		}
		
		//Get videos
		try {
			Set<String> vidsNick1 = iCon.getVideos("nick1");
			assertTrue(vidsNick1.contains("vid1"));
			assertTrue(vidsNick1.contains("vid2"));
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Get DataVideo
		try {
			DataVideo dataVid1 = iCon.getDataVideo("nick1", "vid1");
			assertTrue(dataVid1.getNombre().equals("vid1"));
			assertTrue(dataVid1.getDescripcion().equals("descV1"));
			assertTrue(dataVid1.getDuracion().equals("dur1"));
			assertTrue(dataVid1.getUrl().equals("url1"));
			assertTrue(dataVid1.getFechaPub().equals(LocalDate.of(2011, 11, 11)));
			assertTrue(dataVid1.getCategoria().equals("cat1"));
			assertTrue(dataVid1.getPrivado() == true);
			assertTrue(dataVid1.getAutor().equals("nick1"));
			Set<String> gustanVid1 = dataVid1.getGustan();
			Integer nGustanVid1 = gustanVid1.size();
			assertTrue(nGustanVid1.equals(1));
			assertTrue(gustanVid1.contains("nick3"));
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Get DataVideo 2
		try {
			DataVideo dataVid2 = iCon.getDataVideo("nick2", "vid2");
			assertTrue(dataVid2.getNombre().equals("vid2"));
			assertTrue(dataVid2.getDescripcion().equals("descV2"));
			assertTrue(dataVid2.getDuracion().equals("dur2"));
			assertTrue(dataVid2.getUrl().equals("url2"));
			assertTrue(dataVid2.getFechaPub().equals(LocalDate.of(2022, 12, 22)));
			assertTrue(dataVid2.getPrivado() == true);
			assertTrue(dataVid2.getAutor().equals("nick2"));
			Set<String> gustanVid2 = dataVid2.getGustan();
			Integer nGustanVid2 = gustanVid2.size();
			assertTrue(nGustanVid2.equals(1));
			assertTrue(gustanVid2.contains("nick3"));
			Set<String> noGustanVid2 = dataVid2.getNoGustan();
			Integer nNoGustanVid2 = noGustanVid2.size();
			assertTrue(nNoGustanVid2.equals(1));
			assertTrue(noGustanVid2.contains("nick1"));
			
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Get Listas
		try {
			Set<String> lisNick2 = iCon.getListas("nick2");
			Integer nlisNick2 = lisNick2.size();
			assertTrue(nlisNick2.equals(4));
			assertTrue(lisNick2.contains("listaD1"));
			assertTrue(lisNick2.contains("listaD2"));
			assertTrue(lisNick2.contains("listaP2"));
			assertTrue(lisNick2.contains("listaP3"));
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Get DataLista
		try {
			DataLista dataListaD1 = iCon.getDataLista("nick2", "listaD1");
			assertTrue(dataListaD1.getAutor().equals("nick2"));
			assertTrue(dataListaD1.getNombre().equals("listaD1"));
			assertTrue(dataListaD1.getTipo().equals("Defecto"));
			assertTrue(dataListaD1.getPrivado().equals(true));
			Set<DataPair> parVidsListaD1 = dataListaD1.getVideos();
			Integer nParVidsListaD1 = parVidsListaD1.size();
			assertTrue(nParVidsListaD1.equals(1));
			DataPair[] parArrLD1 = parVidsListaD1.toArray(new DataPair[1]);
			assertTrue(parArrLD1[0].getNickname().equals("nick1"));
			assertTrue(parArrLD1[0].getNombre().equals("vid1"));
			assertTrue(dataListaD1.getCategorias().isEmpty());
			
			DataLista dataListaP2 = iCon.getDataLista("nick2", "listaP2");
			assertTrue(dataListaP2.getAutor().equals("nick2"));
			assertTrue(dataListaP2.getNombre().equals("listaP2"));
			assertTrue(dataListaP2.getTipo().equals("Particular"));
			assertTrue(dataListaP2.getPrivado().equals(true));
			Set<DataPair> parVidsListaP2 = dataListaP2.getVideos();
			Integer nParVidsListaP2 = parVidsListaP2.size();
			assertTrue(nParVidsListaP2.equals(2));
			Set<String> catsLP2 = dataListaP2.getCategorias();
			Integer nCatsLP2 = catsLP2.size();
			assertTrue(nCatsLP2.equals(1));
			assertTrue(catsLP2.contains("cat1"));
			
			iCon.getDataLista("nick2", "noExiste");
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("El usuario nick2 no tiene una lista llamada noExiste"));
		}
		
		//Get DataUsuario
		try {
			iCon.confirmarSeguirUsuario("nick1", "nick2");
			iCon.confirmarSeguirUsuario("nick1", "nick3");
			iCon.confirmarSeguirUsuario("nick4", "nick3");
			
			DataUsuario dataUS1 = iCon.getDataUsuario("nick1");
			assertTrue(dataUS1.getNickname().equals("nick1"));
			assertTrue(dataUS1.getPassword().equals("pass1"));
			assertTrue(dataUS1.getNombre().equals("nom1"));
			assertTrue(dataUS1.getApellido().equals("ape1"));
			assertTrue(dataUS1.getCorreo().equals("cor1"));
			assertTrue(dataUS1.getImagen().equals("img1"));
			assertTrue(dataUS1.getFechaNac().equals(LocalDate.of(2001, 01, 01)));
			Set<String> sigueAU1 = dataUS1.getSigueA();
			Integer nSigueAU1 = sigueAU1.size();
			assertTrue(nSigueAU1.equals(2));
			assertTrue(sigueAU1.contains("nick2"));
			assertTrue(sigueAU1.contains("nick3"));
			assertTrue(dataUS1.getCanal().getAutor().equals("nick1"));
			assertTrue(dataUS1.getCanal().getNombre().equals("nomC1"));
			assertTrue(dataUS1.getCanal().getDescripcion().equals("desc1"));
			assertTrue(dataUS1.getCanal().getCategoria().equals("cat1"));
			assertTrue(dataUS1.getCanal().getPrivado().equals(true));
			Set<String> vidsUS1 = dataUS1.getCanal().getVideos();
			Integer nVidsUS1 = vidsUS1.size();
			assertTrue(nVidsUS1.equals(2));
			assertTrue(vidsUS1.contains("vid1"));
			assertTrue(vidsUS1.contains("vid2"));
			Set<String> lisUS1 = dataUS1.getCanal().getListas();
			Integer nLisUS1 = lisUS1.size();
			assertTrue(nLisUS1.equals(2));
			assertTrue(lisUS1.contains("listaD1"));
			assertTrue(lisUS1.contains("listaD2"));
			
			DataUsuario dataUS3 = iCon.getDataUsuario("nick3");
			assertTrue(dataUS3.getNickname().equals("nick3"));
			assertTrue(dataUS3.getPassword().equals("pass3"));
			assertTrue(dataUS3.getNombre().equals("nom3"));
			assertTrue(dataUS3.getApellido().equals("ape3"));
			assertTrue(dataUS3.getCorreo().equals("cor3"));
			assertTrue(dataUS3.getImagen().equals("img3"));
			assertTrue(dataUS3.getFechaNac().equals(LocalDate.of(2003, 03, 03)));
			Set<String> loSiguenAU3 = dataUS3.getLoSiguen();
			Integer nloSiguenAU3 = loSiguenAU3.size();
			assertTrue(nloSiguenAU3.equals(2));
			assertTrue(loSiguenAU3.contains("nick1"));
			assertTrue(loSiguenAU3.contains("nick4"));
			assertTrue(dataUS3.getCanal().getAutor().equals("nick3"));
			assertTrue(dataUS3.getCanal().getNombre().equals("nomC3"));
			assertTrue(dataUS3.getCanal().getDescripcion().equals("desc3"));
			assertTrue(dataUS3.getCanal().getPrivado().equals(true));
			Set<String> lisUS3 = dataUS3.getCanal().getListas();
			Integer nLisUS3 = lisUS3.size();
			assertTrue(nLisUS3.equals(3));
			assertTrue(lisUS3.contains("listaD1"));
			assertTrue(lisUS3.contains("listaD2"));
			assertTrue(lisUS3.contains("listaP1"));
			
		} catch (NoExisteInstanciaException|RedundanciaException e) {
			assertTrue(e.getMessage().equals("No entro a este assert"));
		}
		
		//Get DataComentarios
		try {
			DataComentarios dataComs = iCon.getDataComentarios("nick1", "vid1");
			assertTrue(dataComs.toString().equals("vid1 :: Comentarios"));
			assertTrue(dataComs.getVideo().equals("vid1"));
			List<DataComentario> lisComs = dataComs.getComentarios();
			Integer nLisComs = lisComs.size();
			assertTrue(nLisComs.equals(2));
			DataComentario datCom1 = lisComs.get(0);
			assertTrue(datCom1.getTexto().equals("Com1"));
			assertTrue(datCom1.getUsuario().equals("nick2"));
			assertTrue(datCom1.getFecha().equals(fechaCom1));
			assertTrue(datCom1.getRuta().equals("1"));
			DataComentario datCom3 = lisComs.get(1);
			assertTrue(datCom3.getTexto().equals("Com3"));
			assertTrue(datCom3.getUsuario().equals("nick1"));
			assertTrue(datCom3.getFecha().equals(fechaCom3));
			assertTrue(datCom3.getRuta().equals("2"));
			
			List<DataComentario> lisComs3 = datCom3.getComentarios();
			Integer nLisComs3 = lisComs3.size();
			assertTrue(nLisComs3.equals(2));
			DataComentario datCom2 = lisComs3.get(0);
			assertTrue(datCom2.getTexto().equals("Com2"));
			assertTrue(datCom2.getUsuario().equals("nick3"));
			assertTrue(datCom2.getFecha().equals(fechaCom2));
			assertTrue(datCom2.getRuta().equals("2.1"));
			DataComentario datCom5 = lisComs3.get(1);
			assertTrue(datCom5.getTexto().equals("Com5"));
			assertTrue(datCom5.getUsuario().equals("nick2"));
			assertTrue(datCom5.getFecha().equals(fechaCom5));
			assertTrue(datCom5.getRuta().equals("2.2"));
			
			List<DataComentario> lisComs2 = datCom2.getComentarios();
			Integer nLisComs2 = lisComs2.size();
			assertTrue(nLisComs2.equals(1));
			DataComentario datCom4 = lisComs2.get(0);
			assertTrue(datCom4.getTexto().equals("Com4"));
			assertTrue(datCom4.getUsuario().equals("nick4"));
			assertTrue(datCom4.getFecha().equals(fechaCom4));
			assertTrue(datCom4.getRuta().equals("2.1.1"));
			
			List<DataComentario> lisComs4 = datCom4.getComentarios();
			Integer nLisComs4 = lisComs4.size();
			assertTrue(nLisComs4.equals(1));
			DataComentario datCom6 = lisComs4.get(0);
			assertTrue(datCom6.getTexto().equals("Com6"));
			assertTrue(datCom6.getUsuario().equals("nick4"));
			assertTrue(datCom6.getFecha().equals(fechaCom6));
			assertTrue(datCom6.getRuta().equals("2.1.1.1"));
			
			assertTrue(datCom5.toString().equals("(nick2) Com5" + fechaCom5.toString()));
			
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entro a este assert"));
		}
		
		//Get DataCategoria
		try {
			DataCategoria dataCat1 = iCon.getDataCategoria("cat1");
			assertTrue(dataCat1.getNombre().equals("cat1"));
			Set<String> usrsCat1 = dataCat1.getUsuarios();
			Integer nUsrsCat1 = usrsCat1.size();
			assertTrue(nUsrsCat1.equals(1));
			assertTrue(usrsCat1.contains("nick1"));
			Set<DataPair> parVidsCat1 = dataCat1.getVideos();
			Integer nParVidsCat1 = parVidsCat1.size();
			assertTrue(nParVidsCat1.equals(2));
			Set<DataPair> parLisCat1 = dataCat1.getListas();
			Integer nParLisCat1 = parLisCat1.size();
			assertTrue(nParLisCat1.equals(1));
			DataPair[] parArrLC1 = parLisCat1.toArray(new DataPair[1]);
			assertTrue(parArrLC1[0].getNickname().equals("nick2"));
			assertTrue(parArrLC1[0].getNombre().equals("listaP2"));

		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entro a este assert"));
		}
		
		//Modificar Video
		DataVideo dataV1Mod = new DataVideo();
		dataV1Mod.setNombre("vid2");
		dataV1Mod.setDescripcion("descV1mod");
		dataV1Mod.setDuracion("dur1mod");
		dataV1Mod.setUrl("url1mod");
		dataV1Mod.setCategoria("cat2");
		dataV1Mod.setPrivado(false);
		LocalDate fechaV1Mod = LocalDate.of(2111, 11, 11);
		dataV1Mod.setFechaPub(fechaV1Mod);
		
		try {
			iCon.confirmarModificarVideo("nick1", "vid1", dataV1Mod);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("El usuario nick1 ya tiene un video llamado vid2"));
		}
		
		dataV1Mod.setNombre("vid1mod");
		
		try {
			iCon.confirmarModificarVideo("nick1", "vid1", dataV1Mod);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("El video no puede ser publico en un canal privado"));
		}
		
		dataV1Mod.setPrivado(true);
		
		try {
			iCon.confirmarModificarVideo("nick1", "vid1", dataV1Mod);
		} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("No entro al assert"));
		}
		
		//Get DataVideo luego de modificar
		try {
			DataVideo dataVid1mod = iCon.getDataVideo("nick1", "vid1mod");
			assertTrue(dataVid1mod.getNombre().equals("vid1mod"));
			assertTrue(dataVid1mod.getDescripcion().equals("descV1mod"));
			assertTrue(dataVid1mod.getDuracion().equals("dur1mod"));
			assertTrue(dataVid1mod.getUrl().equals("url1mod"));
			assertTrue(dataVid1mod.getFechaPub().equals(LocalDate.of(2111, 11, 11)));
			assertTrue(dataVid1mod.getCategoria().equals("cat2"));
			assertTrue(dataVid1mod.getPrivado() == true);
			assertTrue(dataVid1mod.getAutor().equals("nick1"));
			Set<String> gustanVid1 = dataVid1mod.getGustan();
			Integer nGustanVid1 = gustanVid1.size();
			assertTrue(nGustanVid1.equals(1));
			assertTrue(gustanVid1.contains("nick3"));
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Get DataLista luego de modificar video
		try {
			Set<String> dataLluegoDeMod = iCon.getDataLista("nick2", "listaP2").getCategorias();
			Integer nDataLluegoDeMod = dataLluegoDeMod.size();
			assertTrue(nDataLluegoDeMod.equals(1));
			assertTrue(dataLluegoDeMod.contains("cat2"));
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entra a este assert"));
		}
		
		//Modificar Lista
		try {
			iCon.confirmarModificarLista("nick2", "listaD1", true);
		} catch (NoExisteInstanciaException | PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("El usuario nick2 no tiene una lista particular llamada listaD1"));
		}
		
		try {
			iCon.confirmarModificarLista("nick3", "listaP1", false);
		} catch (NoExisteInstanciaException | PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("La lista no puede ser publica en un canal privado"));
		}
		
		try {
			iCon.confirmarModificarLista("nick2", "listaP2", false);
		} catch (NoExisteInstanciaException | PrivacidadInvalidaException e) {
			assertTrue(e.getMessage().equals("No entro al assert"));
		}
		
		//Modificar Usuario
		DataUsuario dataU2mod = new DataUsuario();
		dataU2mod.setNickname("cualquiera");
		dataU2mod.setPassword("pass2mod");
		dataU2mod.setNombre("nom2mod");
		dataU2mod.setApellido("ape2mod");
		dataU2mod.setCorreo("cor2mod");
		dataU2mod.setImagen("img2mod");
		LocalDate fecha2mod = LocalDate.of(2022, 12, 22);
		dataU2mod.setFechaNac(fecha2mod);
		DataCanal dataC2mod = new DataCanal();
		dataC2mod.setNombre("nomC2mod");
		dataC2mod.setDescripcion("desc2mod");
		dataC2mod.setCategoria("cat1");
		dataC2mod.setPrivado(true);
		dataU2mod.setCanal(dataC2mod);
		
		try {
			iCon.confirmarModificarUsuario("nick2", dataU2mod);
			DataUsuario datosU2mod = iCon.getDataUsuario("nick2");
			assertTrue(datosU2mod.getNickname().equals("nick2"));
			assertTrue(datosU2mod.getPassword().equals("pass2mod"));
			assertTrue(datosU2mod.getNombre().equals("nom2mod"));
			assertTrue(datosU2mod.getApellido().equals("ape2mod"));
			assertTrue(datosU2mod.getCorreo().equals("cor2"));
			assertTrue(datosU2mod.getImagen().equals("img2mod"));
			assertTrue(datosU2mod.getFechaNac().equals(LocalDate.of(2022, 12, 22)));
			assertTrue(datosU2mod.getCanal().getNombre().equals("nomC2mod"));
			assertTrue(datosU2mod.getCanal().getDescripcion().equals("desc2mod"));
			assertTrue(datosU2mod.getCanal().getCategoria().equals("cat1"));
			assertTrue(datosU2mod.getCanal().getPrivado().equals(true));
			
			assertTrue(iCon.getDataLista("nick2", "listaP2").getPrivado().equals(true));
			assertTrue(iCon.getDataVideo("nick2", "vid2").getPrivado().equals(true));
			
		} catch (NoExisteInstanciaException e) {
			assertTrue(e.getMessage().equals("No entro al assert"));
		}
	}

}
