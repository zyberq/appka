/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maciej_Paszkowski
 */
@Entity
@Table(name = "kategorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorie.findAll", query = "SELECT k FROM Kategorie k"),
    @NamedQuery(name = "Kategorie.findByKategorieId", query = "SELECT k FROM Kategorie k WHERE k.kategorieId = :kategorieId"),
    @NamedQuery(name = "Kategorie.findByNazwa", query = "SELECT k FROM Kategorie k WHERE k.nazwa = :nazwa")})
public class Kategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategorie_id")
    private Integer kategorieId;
    @Size(max = 255)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorie")
    private Collection<ProduktyHasKategorie> produktyHasKategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorie")
    private Collection<KategorieHasKategorie> kategorieHasKategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorie1")
    private Collection<KategorieHasKategorie> kategorieHasKategorieCollection1;
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User fkUserId;

    public Kategorie() {
    }

    public Kategorie(Integer kategorieId) {
        this.kategorieId = kategorieId;
    }

    public Integer getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Integer kategorieId) {
        this.kategorieId = kategorieId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<ProduktyHasKategorie> getProduktyHasKategorieCollection() {
        return produktyHasKategorieCollection;
    }

    public void setProduktyHasKategorieCollection(Collection<ProduktyHasKategorie> produktyHasKategorieCollection) {
        this.produktyHasKategorieCollection = produktyHasKategorieCollection;
    }

    @XmlTransient
    public Collection<KategorieHasKategorie> getKategorieHasKategorieCollection() {
        return kategorieHasKategorieCollection;
    }

    public void setKategorieHasKategorieCollection(Collection<KategorieHasKategorie> kategorieHasKategorieCollection) {
        this.kategorieHasKategorieCollection = kategorieHasKategorieCollection;
    }

    @XmlTransient
    public Collection<KategorieHasKategorie> getKategorieHasKategorieCollection1() {
        return kategorieHasKategorieCollection1;
    }

    public void setKategorieHasKategorieCollection1(Collection<KategorieHasKategorie> kategorieHasKategorieCollection1) {
        this.kategorieHasKategorieCollection1 = kategorieHasKategorieCollection1;
    }

    public User getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(User fkUserId) {
        this.fkUserId = fkUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategorieId != null ? kategorieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorie)) {
            return false;
        }
        Kategorie other = (Kategorie) object;
        if ((this.kategorieId == null && other.kategorieId != null) || (this.kategorieId != null && !this.kategorieId.equals(other.kategorieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.Kategorie[ kategorieId=" + kategorieId + " ]";
    }
    
}
