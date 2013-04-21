/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produkt;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maciej_Paszkowski
 */
@Entity
@Table(name = "faktury")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faktury.findAll", query = "SELECT f FROM Faktury f"),
    @NamedQuery(name = "Faktury.findByFakturyId", query = "SELECT f FROM Faktury f WHERE f.fakturyId = :fakturyId"),
    @NamedQuery(name = "Faktury.findByDataFakt", query = "SELECT f FROM Faktury f WHERE f.dataFakt = :dataFakt"),
    @NamedQuery(name = "Faktury.findByNumerRach", query = "SELECT f FROM Faktury f WHERE f.numerRach = :numerRach"),
    @NamedQuery(name = "Faktury.findByPozostaloDoZaplaty", query = "SELECT f FROM Faktury f WHERE f.pozostaloDoZaplaty = :pozostaloDoZaplaty"),
    @NamedQuery(name = "Faktury.findBySuma", query = "SELECT f FROM Faktury f WHERE f.suma = :suma"),
    @NamedQuery(name = "Faktury.findByTyp", query = "SELECT f FROM Faktury f WHERE f.typ = :typ"),
    @NamedQuery(name = "Faktury.findByZaplacone", query = "SELECT f FROM Faktury f WHERE f.zaplacone = :zaplacone")})
public class Faktury implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faktury_id")
    private Integer fakturyId;
    @Column(name = "data_fakt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFakt;
    @Size(max = 255)
    @Column(name = "numer_rach")
    private String numerRach;
    @Column(name = "pozostalo_do_zaplaty")
    private BigInteger pozostaloDoZaplaty;
    @Column(name = "suma")
    private BigInteger suma;
    @Size(max = 255)
    @Column(name = "typ")
    private String typ;
    @Column(name = "zaplacone")
    private Boolean zaplacone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faktury")
    private Collection<FakturyHasProdukty> fakturyHasProduktyCollection;
    @JoinColumn(name = "transakcja_id_fk", referencedColumnName = "transakcja_id")
    @ManyToOne
    private Transakcja transakcjaIdFk;
    @JoinColumn(name = "kto", referencedColumnName = "dane_firmy_id")
    @ManyToOne
    private DaneFirmy kto;
    @JoinColumn(name = "komu", referencedColumnName = "dane_firmy_id")
    @ManyToOne
    private DaneFirmy komu;
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User userIdFk;

    public Faktury() {
    }

    public Faktury(Integer fakturyId) {
        this.fakturyId = fakturyId;
    }

    public Integer getFakturyId() {
        return fakturyId;
    }

    public void setFakturyId(Integer fakturyId) {
        this.fakturyId = fakturyId;
    }

    public Date getDataFakt() {
        return dataFakt;
    }

    public void setDataFakt(Date dataFakt) {
        this.dataFakt = dataFakt;
    }

    public String getNumerRach() {
        return numerRach;
    }

    public void setNumerRach(String numerRach) {
        this.numerRach = numerRach;
    }

    public BigInteger getPozostaloDoZaplaty() {
        return pozostaloDoZaplaty;
    }

    public void setPozostaloDoZaplaty(BigInteger pozostaloDoZaplaty) {
        this.pozostaloDoZaplaty = pozostaloDoZaplaty;
    }

    public BigInteger getSuma() {
        return suma;
    }

    public void setSuma(BigInteger suma) {
        this.suma = suma;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Boolean getZaplacone() {
        return zaplacone;
    }

    public void setZaplacone(Boolean zaplacone) {
        this.zaplacone = zaplacone;
    }

    @XmlTransient
    public Collection<FakturyHasProdukty> getFakturyHasProduktyCollection() {
        return fakturyHasProduktyCollection;
    }

    public void setFakturyHasProduktyCollection(Collection<FakturyHasProdukty> fakturyHasProduktyCollection) {
        this.fakturyHasProduktyCollection = fakturyHasProduktyCollection;
    }

    public Transakcja getTransakcjaIdFk() {
        return transakcjaIdFk;
    }

    public void setTransakcjaIdFk(Transakcja transakcjaIdFk) {
        this.transakcjaIdFk = transakcjaIdFk;
    }

    public DaneFirmy getKto() {
        return kto;
    }

    public void setKto(DaneFirmy kto) {
        this.kto = kto;
    }

    public DaneFirmy getKomu() {
        return komu;
    }

    public void setKomu(DaneFirmy komu) {
        this.komu = komu;
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
        hash += (fakturyId != null ? fakturyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktury)) {
            return false;
        }
        Faktury other = (Faktury) object;
        if ((this.fakturyId == null && other.fakturyId != null) || (this.fakturyId != null && !this.fakturyId.equals(other.fakturyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.Faktury[ fakturyId=" + fakturyId + " ]";
    }
    
}
