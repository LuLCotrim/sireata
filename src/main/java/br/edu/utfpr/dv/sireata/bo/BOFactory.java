package br.edu.utfpr.dv.sireata.bo;

import br.edu.utfpr.dv.sireata.dao.DAOSuper;

public abstract class BOFactory {
    
    public enum BO{
        AnexoDAO,
        AtaDAO,
        AtaParticipanteDAO,
        CampusDAO,
        ComentarioDAO,
        DepartamentoDAO,
        OrgaoDAO,
        PautaDAO,
        UsuarioDAO;
    }

    public static DAOSuper from(BO bo){
        switch(bo){
            case AnexoDAO:
                return new br.edu.utfpr.dv.sireata.bo.AnexoBO().getDAO();
            case AtaDAO:
                return new br.edu.utfpr.dv.sireata.bo.AtaBO().getDAO();
            case AtaParticipanteDAO:
                return new br.edu.utfpr.dv.sireata.bo.AtaParticipanteBO().getDAO();
            case CampusDAO:
                return new br.edu.utfpr.dv.sireata.bo.CampusBO().getDAO();
            case ComentarioDAO:
                return new br.edu.utfpr.dv.sireata.bo.ComentarioBO().getDAO();
            case DepartamentoDAO:
                return new br.edu.utfpr.dv.sireata.bo.DepartamentoBO().getDAO();
            case OrgaoDAO:
                return new br.edu.utfpr.dv.sireata.bo.OrgaoBO().getDAO();
            case PautaDAO:
                return new br.edu.utfpr.dv.sireata.bo.PautaBO().getDAO();
            case UsuarioDAO:
                return new br.edu.utfpr.dv.sireata.bo.UsuarioBO().getDAO();
            default:
                return null;
        }
    }
    
    public abstract DAOSuper getDAO();
}
