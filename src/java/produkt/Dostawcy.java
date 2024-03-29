/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "dostawcy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawcy.findAll", query = "SELECT d FROM Dostawcy d"),
    @NamedQuery(name = "Dostawcy.findByDostawcyId", query = "SELECT d FROM Dostawcy d WHERE d.dostawcyId = :dostawcyId"),
    @NamedQuery(name = "Dostawcy.findByEmail", query = "SELECT d FROM Dostawcy d WHERE d.email = :email"),
    @NamedQuery(name = "Dostawcy.findByNazwaWlasna", query = "SELECT d FROM Dostawcy d WHERE d.nazwaWlasna = :nazwaWlasna"),
    @NamedQuery(name = "Dostawcy.findByOsobaKont", query = "SELECT d FROM Dostawcy d WHERE d.osobaKont = :osobaKont"),
    @NamedQuery(name = "Dostawcy.findByTelefon", query = "SELECT d FROM Dostawcy d WHERE d.telefon = :telefon")})
public class Dostawcy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dostawcy_id")
    private Integer dostawcyId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "nazwa_wlasna")
    private String nazwaWlasna;
    @Size(max = 255)
    @Column(name = "osoba_kont")
    private String osobaKont;
    @Size(max = 255)
    @Column(name = "telefon")
    private String telefon;
    @OneToMany(mappedBy = "dostawcaIdFk")
    private Collection<Zamowienia> zamowieniaCollection;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;
    @JoinColumn(name = "dane_firmy_id_fk", referencedColumnName = "dane_firmy_id")
    @ManyToOne
    private DaneFirmy daneFirmyIdFk;
    @OneToMany(mappedBy = "dostawcaIdFk")
    private Collection<Produkty> produktyCollection;

    public Dostawcy() {
    }

    public Dostawcy(Integer dostawcyId) {
        this.dostawcyId = dostawcyId;
    }

    public Integer getDostawcyId() {
        return dostawcyId;
    }

    public void setDostawcyId(Integer dostawcyId) {
        this.dostawcyId = dostawcyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNazwaWlasna() {
        return nazwaWlasna;
    }

    public void setNazwaWlasna(String nazwaWlasna) {
        this.nazwaWlasna = nazwaWlasna;
    }

    public String getOsobaKont() {
        return osobaKont;
    }

    public void setOsobaKont(String osobaKont) {
        this.osobaKont = osobaKont;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public Collection<Zamowienia> getZamowieniaCollection() {
        return zamowieniaCollection;
    }

    public void setZamowieniaCollection(Collection<Zamowienia> zamowieniaCollection) {
        this.zamowieniaCollection = zamowieniaCollection;
    }

    public User getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(User userIdFk) {
        this.userIdFk = userIdFk;
    }

    public DaneFirmy getDaneFirmyIdFk() {
        return daneFirmyIdFk;
    }

    public void setDaneFirmyIdFk(DaneFirmy daneFirmyIdFk) {
        this.daneFirmyIdFk = daneFirmyIdFk;
    }

    @XmlTransient
    public Collection<Produkty> getProduktyCollection() {
        return produktyCollection;
    }

    public void setProduktyCollection(Collection<Produkty> produktyCollection) {
        this.produktyCollection = produktyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dostawcyId != null ? dostawcyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawcy)) {
            return false;
        }
        Dostawcy other = (Dostawcy) object;
        if ((this.dostawcyId == null && other.dostawcyId != null) || (this.dostawcyId != null && !this.dostawcyId.equals(other.dostawcyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.Dostawcy[ dostawcyId=" + dostawcyId + " ]";
    }
    
}
