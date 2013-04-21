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
@Table(name = "adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a"),
    @NamedQuery(name = "Adres.findByAdresId", query = "SELECT a FROM Adres a WHERE a.adresId = :adresId"),
    @NamedQuery(name = "Adres.findByKodPocztowy", query = "SELECT a FROM Adres a WHERE a.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Adres.findByMiasto", query = "SELECT a FROM Adres a WHERE a.miasto = :miasto"),
    @NamedQuery(name = "Adres.findByNrDomu", query = "SELECT a FROM Adres a WHERE a.nrDomu = :nrDomu"),
    @NamedQuery(name = "Adres.findByStatus", query = "SELECT a FROM Adres a WHERE a.status = :status"),
    @NamedQuery(name = "Adres.findByUlica", query = "SELECT a FROM Adres a WHERE a.ulica = :ulica")})
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adres_id")
    private Integer adresId;
    @Size(max = 255)
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    @Size(max = 255)
    @Column(name = "miasto")
    private String miasto;
    @Size(max = 255)
    @Column(name = "nr_domu")
    private String nrDomu;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "ulica")
    private String ulica;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;
    @OneToMany(mappedBy = "adresIdFk")
    private Collection<Klient> klientCollection;
    @OneToMany(mappedBy = "adresIdFk")
    private Collection<DaneFirmy> daneFirmyCollection;

    public Adres() {
    }

    public Adres(Integer adresId) {
        this.adresId = adresId;
    }

    public Integer getAdresId() {
        return adresId;
    }

    public void setAdresId(Integer adresId) {
        this.adresId = adresId;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public User getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(User userIdFk) {
        this.userIdFk = userIdFk;
    }

    @XmlTransient
    public Collection<Klient> getKlientCollection() {
        return klientCollection;
    }

    public void setKlientCollection(Collection<Klient> klientCollection) {
        this.klientCollection = klientCollection;
    }

    @XmlTransient
    public Collection<DaneFirmy> getDaneFirmyCollection() {
        return daneFirmyCollection;
    }

    public void setDaneFirmyCollection(Collection<DaneFirmy> daneFirmyCollection) {
        this.daneFirmyCollection = daneFirmyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresId != null ? adresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.adresId == null && other.adresId != null) || (this.adresId != null && !this.adresId.equals(other.adresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.Adres[ adresId=" + adresId + " ]";
    }
    
}
