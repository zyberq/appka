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
public class FakturyFacade extends AbstractFacade<Faktury> {
    @PersistenceContext(unitName = "appkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FakturyFacade() {
        super(Faktury.class);
    }
    
}