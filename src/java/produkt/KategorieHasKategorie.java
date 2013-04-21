/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "kategorie_has_kategorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KategorieHasKategorie.findAll", query = "SELECT k FROM KategorieHasKategorie k"),
    @NamedQuery(name = "KategorieHasKategorie.findByDepth", query = "SELECT k FROM KategorieHasKategorie k WHERE k.depth = :depth"),
    @NamedQuery(name = "KategorieHasKategorie.findByKategorieKategorieId", query = "SELECT k FROM KategorieHasKategorie k WHERE k.kategorieHasKategoriePK.kategorieKategorieId = :kategorieKategorieId"),
    @NamedQuery(name = "KategorieHasKategorie.findByKategorieParentKategorieId", query = "SELECT k FROM KategorieHasKategorie k WHERE k.kategorieHasKategoriePK.kategorieParentKategorieId = :kategorieParentKategorieId")})
public class KategorieHasKategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KategorieHasKategoriePK kategorieHasKategoriePK;
    @Column(name = "depth")
    private Integer depth;
    @JoinColumn(name = "kategorie_kategorie_id", referencedColumnName = "kategorie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kategorie kategorie;
    @JoinColumn(name = "kategorie_parent_kategorie_id", referencedColumnName = "kategorie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kategorie kategorie1;

    public KategorieHasKategorie() {
    }

    public KategorieHasKategorie(KategorieHasKategoriePK kategorieHasKategoriePK) {
        this.kategorieHasKategoriePK = kategorieHasKategoriePK;
    }

    public KategorieHasKategorie(int kategorieKategorieId, int kategorieParentKategorieId) {
        this.kategorieHasKategoriePK = new KategorieHasKategoriePK(kategorieKategorieId, kategorieParentKategorieId);
    }

    public KategorieHasKategoriePK getKategorieHasKategoriePK() {
        return kategorieHasKategoriePK;
    }

    public void setKategorieHasKategoriePK(KategorieHasKategoriePK kategorieHasKategoriePK) {
        this.kategorieHasKategoriePK = kategorieHasKategoriePK;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Kategorie getKategorie1() {
        return kategorie1;
    }

    public void setKategorie1(Kategorie kategorie1) {
        this.kategorie1 = kategorie1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategorieHasKategoriePK != null ? kategorieHasKategoriePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KategorieHasKategorie)) {
            return false;
        }
        KategorieHasKategorie other = (KategorieHasKategorie) object;
        if ((this.kategorieHasKategoriePK == null && other.kategorieHasKategoriePK != null) || (this.kategorieHasKategoriePK != null && !this.kategorieHasKategoriePK.equals(other.kategorieHasKategoriePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.KategorieHasKategorie[ kategorieHasKategoriePK=" + kategorieHasKategoriePK + " ]";
    }
    
}
