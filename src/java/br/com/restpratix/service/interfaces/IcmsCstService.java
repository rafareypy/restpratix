/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service.interfaces;

import br.com.pratixrest.model.IcmsCst;

/**
 *
 * @author pontocom
 */
public interface IcmsCstService {
 
    IcmsCst saveIcmsCst(IcmsCst icmsCst);
    IcmsCst updateIcmsCst(IcmsCst icmsCst);
    IcmsCst deleteIcmsCst(IcmsCst icmsCst);
    IcmsCst getIcmsCst(IcmsCst icmsCst);
    IcmsCst getIcmsCst(Integer id);
    IcmsCst getListIcmsCst();
    
    
}
