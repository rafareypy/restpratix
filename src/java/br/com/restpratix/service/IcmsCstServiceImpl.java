/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.IcmsCst;
import br.com.restpratix.service.interfaces.IcmsCstService;

/**
 *
 * @author pontocom
 */
public class IcmsCstServiceImpl extends BasicService implements IcmsCstService {

    @Override
    public IcmsCst saveIcmsCst(IcmsCst icmsCst) {

        try {
            getEm().getTransaction().begin();
            getEm().persist(icmsCst);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();

        }finally{
            if(getEm().isOpen())
                getEm().close();
        }

        return icmsCst ;
    }

    @Override
    public IcmsCst updateIcmsCst(IcmsCst icmsCst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IcmsCst deleteIcmsCst(IcmsCst icmsCst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IcmsCst getIcmsCst(IcmsCst icmsCst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IcmsCst getIcmsCst(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IcmsCst getListIcmsCst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
