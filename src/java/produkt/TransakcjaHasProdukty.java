/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maciej_Paszkowski
 */
@Entity
@Table(name = "transakcja_has_produkty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransakcjaHasProdukty.findAll", query = "SELECT t FROM TransakcjaHasProdukty t"),
    @NamedQuery(name = "TransakcjaHasProdukty.findByProduktyProduktyId", query = "SELECT t FROM TransakcjaHasProdukty t WHERE t.transakcjaHasProduktyPK.produktyProduktyId = :produktyProduktyId"),
    @NamedQuery(name = "TransakcjaHasProdukty.findByTransakcjaTransakcjaId", query = "SELECT t FROM TransakcjaHasProdukty t WHERE t.transakcjaHasProduktyPK.transakcjaTransakcjaId = :transakcjaTransakcjaId")})
public class TransakcjaHasProdukty implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransakcjaHasProduktyPK transakcjaHasProduktyPK;
    @JoinColumn(name = "transakcja_transakcja_id", referencedColumnName = "transakcja_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transakcja transakcja;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;
    @JoinColumn(name = "produkty_produkty_id", referencedColumnName = "produkty_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produkty produkty;

    public TransakcjaHasProdukty() {
    }

    public TransakcjaHasProdukty(TransakcjaHasProduktyPK transakcjaHasProduktyPK) {
        this.transakcjaHasProduktyPK = transakcjaHasProduktyPK;
    }

    public TransakcjaHasProdukty(int produktyProduktyId, int transakcjaTransakcjaId) {
        this.transakcjaHasProduktyPK = new TransakcjaHasProduktyPK(produktyProduktyId, transakcjaTransakcjaId);
    }

    public TransakcjaHasProduktyPK getTransakcjaHasProduktyPK() {
        return transakcjaHasProduktyPK;
    }

    public void setTransakcjaHasProduktyPK(TransakcjaHasProduktyPK transakcjaHasProduktyPK) {
        this.transakcjaHasProduktyPK = transakcjaHasProduktyPK;
    }

    public Transakcja getTransakcja() {
        return transakcja;
    }

    public void setTransakcja(Transakcja transakcja) {
        this.transakcja = transakcja;
    }

    public User getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(User userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Produkty getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkty produkty) {
        this.produkty = produkty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transakcjaHasProduktyPK != null ? transakcjaHasProduktyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransakcjaHasProdukty)) {
            return false;
        }
        TransakcjaHasProdukty other = (TransakcjaHasProdukty) object;
        if ((this.transakcjaHasProduktyPK == null && other.transakcjaHasProduktyPK != null) || (this.transakcjaHasProduktyPK != null && !this.transakcjaHasProduktyPK.equals(other.transakcjaHasProduktyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.TransakcjaHasProdukty[ transakcjaHasProduktyPK=" + transakcjaHasProduktyPK + " ]";
    }
    
}
