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
public class ProduktyHasKategoriePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "kategorie_kategorie_id")
    private int kategorieKategorieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "produkty_produkty_id")
    private int produktyProduktyId;

    public ProduktyHasKategoriePK() {
    }

    public ProduktyHasKategoriePK(int kategorieKategorieId, int produktyProduktyId) {
        this.kategorieKategorieId = kategorieKategorieId;
        this.produktyProduktyId = produktyProduktyId;
    }

    public int getKategorieKategorieId() {
        return kategorieKategorieId;
    }

    public void setKategorieKategorieId(int kategorieKategorieId) {
        this.kategorieKategorieId = kategorieKategorieId;
    }

    public int getProduktyProduktyId() {
        return produktyProduktyId;
    }

    public void setProduktyProduktyId(int produktyProduktyId) {
        this.produktyProduktyId = produktyProduktyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) kategorieKategorieId;
        hash += (int) produktyProduktyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduktyHasKategoriePK)) {
            return false;
        }
        ProduktyHasKategoriePK other = (ProduktyHasKategoriePK) object;
        if (this.kategorieKategorieId != other.kategorieKategorieId) {
            return false;
        }
        if (this.produktyProduktyId != other.produktyProduktyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.ProduktyHasKategoriePK[ kategorieKategorieId=" + kategorieKategorieId + ", produktyProduktyId=" + produktyProduktyId + " ]";
    }
    
}
