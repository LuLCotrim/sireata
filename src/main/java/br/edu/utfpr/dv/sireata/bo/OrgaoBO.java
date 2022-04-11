package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.OrgaoDAO;
import br.edu.utfpr.dv.sireata.model.Orgao;
import br.edu.utfpr.dv.sireata.model.OrgaoMembro;
import br.edu.utfpr.dv.sireata.model.Usuario;

public class OrgaoBO {
	
	public Orgao buscarPorId(int id) throws Exception{
		try{
			return new OrgaoDAO().buscarPorId(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listarTodos(boolean apenasAtivos) throws Exception{
		try{
			return new OrgaoDAO().listarTodos(apenasAtivos);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listarPorDepartamento(int idDepartamento) throws Exception{
		try{
			return new OrgaoDAO().listarPorDepartamento(idDepartamento);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listarPorCampus(int idCampus) throws Exception{
		try{
			return new OrgaoDAO().listarPorCampus(idCampus);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listarParaCriacaoAta(int idDepartamento, int idUsuario) throws Exception{
		try{
			return new OrgaoDAO().listarParaCriacaoAta(idDepartamento, idUsuario);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listarParaConsultaAtas(int idDepartamento, int idUsuario) throws Exception{
		try{
			return new OrgaoDAO().listarParaConsultaAtas(idDepartamento, idUsuario);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Orgao> listar(int idCampus, int idDepartamento) throws Exception{
		if(idDepartamento > 0){
			return this.listarPorDepartamento(idDepartamento);
		}else if(idCampus > 0){
			return this.listarPorCampus(idCampus);
		}else{
			return this.listarTodos(true);
		}
	}
	
	public Usuario buscarPresidente(int idOrgao) throws Exception{
		try{
			return new OrgaoDAO().buscarPresidente(idOrgao);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public Usuario buscarSecretario(int idOrgao) throws Exception{
		try{
			return new OrgaoDAO().buscarSecretario(idOrgao);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean isMembro(int idOrgao, int idUsuario) throws Exception{
		try{
			return new OrgaoDAO().isMembro(idOrgao, idUsuario);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public int salvar(Orgao orgao) throws Exception{
		if(orgao.getNome().isEmpty()){
			throw new Exception("Informe o nome do câmpus.");
		}
		if((orgao.getDepartamento() == null) || (orgao.getDepartamento().getIdDepartamento() == 0)){
			throw new Exception("Selecione o departamento.");
		}
		if((orgao.getPresidente() == null) || (orgao.getPresidente().getIdUsuario() == 0)){
			throw new Exception("Selecione o presidente.");
		}
		if((orgao.getSecretario() == null) || (orgao.getSecretario().getIdUsuario() == 0)){
			throw new Exception("Selecione o secretário");
		}
		
		boolean encontrou = false;
		
		for(OrgaoMembro u : orgao.getMembros()){
			if(u.getUsuario().getIdUsuario() == orgao.getPresidente().getIdUsuario()){
				encontrou = true;
				break;
			}
		}
		if(!encontrou){
			OrgaoMembro membro = new OrgaoMembro();
			membro.setUsuario(orgao.getPresidente());
			membro.setDesignacao("coordenador");
			orgao.getMembros().add(membro);
		}
		
		try{
			return new OrgaoDAO().salvar(orgao);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}

}
