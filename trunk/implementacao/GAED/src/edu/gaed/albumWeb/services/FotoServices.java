package edu.gaed.albumWeb.services;

import java.util.List;



import edu.gaed.albumWeb.exception.PersistenceException;
import edu.gaed.vo.Foto;
import edu.gaed.dao.FotoDao;

public class FotoServices {

	private static FotoServices instance = null;
	
	private FotoServices() {
		//do nothing
	}
	
	public static FotoServices getInstance() {
		if (instance == null) {
			instance = new FotoServices();			
		}
		return instance;
	}
	
	public Foto obterFoto(Foto foto) throws PersistenceException {
		FotoDao fotoDao = new FotoDao();
		return fotoDao.getFoto(foto);
	}

	public List<Foto> obterFotos() throws PersistenceException {
		FotoDao fotoDao = new FotoDao();
		return fotoDao.getFotos();
	}
	
	public void salvarFoto(Foto foto) throws PersistenceException {
		FotoDao fotoDao = new FotoDao();
		if (foto.getId() > 0) {
			fotoDao.updateFoto(foto);
		}
		else {
			fotoDao.insertFoto(foto);
		}
	}
	
	public boolean removerFoto(Foto foto) throws PersistenceException {
		FotoDao fotoDao = new FotoDao();
		return fotoDao.deleteFoto(foto);
	}
}
