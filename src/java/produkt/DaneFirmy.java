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
@Table(name = "dane_firmy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaneFirmy.findAll", query = "SELECT d FROM DaneFirmy d"),
    @NamedQuery(name = "DaneFirmy.findByDaneFirmyId", query = "SELECT d FROM DaneFirmy d WHERE d.daneFirmyId = :daneFirmyId"),
    @NamedQuery(name = "DaneFirmy.findByBank", query = "SELECT d FROM DaneFirmy d WHERE d.bank = :bank"),
    @NamedQuery(name = "DaneFirmy.findByNazwaFirmy", query = "SELECT d FROM DaneFirmy d WHERE d.nazwaFirmy = :nazwaFirmy"),
    @NamedQuery(name = "DaneFirmy.findByNip", query = "SELECT d FROM DaneFirmy d WHERE d.nip = :nip"),
    @NamedQuery(name = "DaneFirmy.findByNrkonta", query = "SELECT d FROM DaneFirmy d WHERE d.nrkonta = :nrkonta"),
    @NamedQuery(name = "DaneFirmy.findByRegon", query = "SELECT d FROM DaneFirmy d WHERE d.regon = :regon"),
    @NamedQuery(name = "DaneFirmy.findByStatus", query = "SELECT d FROM DaneFirmy d WHERE d.status = :status")})
public class DaneFirmy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dane_firmy_id")
    private Integer daneFirmyId;
    @Size(max = 255)
    @Column(name = "bank")
    private String bank;
    @Size(max = 255)
    @Column(name = "nazwa_firmy")
    private String nazwaFirmy;
    @Size(max = 255)
    @Column(name = "nip")
    private String nip;
    @Size(max = 255)
    @Column(name = "nrkonta")
    private String nrkonta;
    @Size(max = 255)
    @Column(name = "regon")
    private String regon;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "daneFirmyIdFk")
    private Collection<Klient> klientCollection;
    @OneToMany(mappedBy = "kto")
    private Collection<Faktury> fakturyCollection;
    @OneToMany(mappedBy = "komu")
    private Collection<Faktury> fakturyCollection1;
    @OneToMany(mappedBy = "daneFirmyIdFk")
    private Collection<Dostawcy> dostawcyCollection;
    @JoinColumn(name = "adres_id_fk", referencedColumnName = "adres_id")
    @ManyToOne
    private Adres adresIdFk;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;

    public DaneFirmy() {
    }

    public DaneFirmy(Integer daneFirmyId) {
        this.daneFirmyId = daneFirmyId;
    }

    public Integer getDaneFirmyId() {
        return daneFirmyId;
    }

    public void setDaneFirmyId(Integer daneFirmyId) {
        this.daneFirmyId = daneFirmyId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNrkonta() {
        return nrkonta;
    }

    public void setNrkonta(String nrkonta) {
        this.nrkonta = nrkonta;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Klient> getKlientCollection() {
        return klientCollection;
    }

    public void setKlientCollection(Collection<Klient> klientCollection) {
        this.klientCollection = klientCollection;
    }

    @XmlTransient
    public Collection<Faktury> getFakturyCollection() {
        return fakturyCollection;
    }

    public void setFakturyCollection(Collection<Faktury> fakturyCollection) {
        this.fakturyCollection = fakturyCollection;
    }

    @XmlTransient
    public Collection<Faktury> getFakturyCollection1() {
        return fakturyCollection1;
    }

    public void setFakturyCollection1(Collection<Faktury> fakturyCollection1) {
        this.fakturyCollection1 = fakturyCollection1;
    }

    @XmlTransient
    public Collection<Dostawcy> getDostawcyCollection() {
        return dostawcyCollection;
    }

    public void setDostawcyCollection(Collection<Dostawcy> dostawcyCollection) {
        this.dostawcyCollection = dostawcyCollection;
    }

    public Adres getAdresIdFk() {
        return adresIdFk;
    }

    public void setAdresIdFk(Adres adresIdFk) {
        this.adresIdFk = adresIdFk;
    }

    public User getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(User userIdFk) {
        this.userIdFk = userIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (daneFirmyId != null ? daneFirmyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaneFirmy)) {
            return false;
        }
        DaneFirmy other = (DaneFirmy) object;
        if ((this.daneFirmyId == null && other.daneFirmyId != null) || (this.daneFirmyId != null && !this.daneFirmyId.equals(other.daneFirmyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.DaneFirmy[ daneFirmyId=" + daneFirmyId + " ]";
    }
    
}
