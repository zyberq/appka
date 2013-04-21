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
public class KategorieHasKategoriePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "kategorie_kategorie_id")
    private int kategorieKategorieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kategorie_parent_kategorie_id")
    private int kategorieParentKategorieId;

    public KategorieHasKategoriePK() {
    }

    public KategorieHasKategoriePK(int kategorieKategorieId, int kategorieParentKategorieId) {
        this.kategorieKategorieId = kategorieKategorieId;
        this.kategorieParentKategorieId = kategorieParentKategorieId;
    }

    public int getKategorieKategorieId() {
        return kategorieKategorieId;
    }

    public void setKategorieKategorieId(int kategorieKategorieId) {
        this.kategorieKategorieId = kategorieKategorieId;
    }

    public int getKategorieParentKategorieId() {
        return kategorieParentKategorieId;
    }

    public void setKategorieParentKategorieId(int kategorieParentKategorieId) {
        this.kategorieParentKategorieId = kategorieParentKategorieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) kategorieKategorieId;
        hash += (int) kategorieParentKategorieId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KategorieHasKategoriePK)) {
            return false;
        }
        KategorieHasKategoriePK other = (KategorieHasKategoriePK) object;
        if (this.kategorieKategorieId != other.kategorieKategorieId) {
            return false;
        }
        if (this.kategorieParentKategorieId != other.kategorieParentKategorieId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.KategorieHasKategoriePK[ kategorieKategorieId=" + kategorieKategorieId + ", kategorieParentKategorieId=" + kategorieParentKategorieId + " ]";
    }
    
}
