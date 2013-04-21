/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maciej_Paszkowski
 */
@Stateless
public class KategorieFacade extends AbstractFacade<Kategorie> {
    @PersistenceContext(unitName = "appkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KategorieFacade() {
        super(Kategorie.class);
    }
    
}
