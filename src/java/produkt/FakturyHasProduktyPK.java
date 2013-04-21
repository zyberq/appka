/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Maciej_Paszkowski
 */
@Embeddable
public class FakturyHasProduktyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "produkty_produkty_id")
    private int produktyProduktyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faktury_faktury_id")
    private int fakturyFakturyId;

    public FakturyHasProduktyPK() {
    }

    public FakturyHasProduktyPK(int produktyProduktyId, int fakturyFakturyId) {
        this.produktyProduktyId = produktyProduktyId;
        this.fakturyFakturyId = fakturyFakturyId;
    }

    public int getProduktyProduktyId() {
        return produktyProduktyId;
    }

    public void setProduktyProduktyId(int produktyProduktyId) {
        this.produktyProduktyId = produktyProduktyId;
    }

    public int getFakturyFakturyId() {
        return fakturyFakturyId;
    }

    public void setFakturyFakturyId(int fakturyFakturyId) {
        this.fakturyFakturyId = fakturyFakturyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produktyProduktyId;
        hash += (int) fakturyFakturyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FakturyHasProduktyPK)) {
            return false;
        }
        FakturyHasProduktyPK other = (FakturyHasProduktyPK) object;
        if (this.produktyProduktyId != other.produktyProduktyId) {
            return false;
        }
        if (this.fakturyFakturyId != other.fakturyFakturyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.FakturyHasProduktyPK[ produktyProduktyId=" + produktyProduktyId + ", fakturyFakturyId=" + fakturyFakturyId + " ]";
    }
    
}
