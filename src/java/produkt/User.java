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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByImie", query = "SELECT u FROM User u WHERE u.imie = :imie"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByNazwisko", query = "SELECT u FROM User u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByUprawnienia", query = "SELECT u FROM User u WHERE u.uprawnienia = :uprawnienia")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "imie")
    private String imie;
    @Size(max = 255)
    @Column(name = "login")
    private String login;
    @Size(max = 255)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "uprawnienia")
    private Integer uprawnienia;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<ProduktyHasKategorie> produktyHasKategorieCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Adres> adresCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<FakturyHasProdukty> fakturyHasProduktyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Klient> klientCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Faktury> fakturyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Transakcja> transakcjaCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Zamowienia> zamowieniaCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Dostawcy> dostawcyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Produkty> produktyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<ProduktyHasZamowienia> produktyHasZamowieniaCollection;
    @OneToMany(mappedBy = "fkUserId")
    private Collection<Kategorie> kategorieCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<DaneFirmy> daneFirmyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<TransakcjaHasProdukty> transakcjaHasProduktyCollection;
    @OneToMany(mappedBy = "userIdFk")
    private Collection<Regal> regalCollection;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(Integer uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    @XmlTransient
    public Collection<ProduktyHasKategorie> getProduktyHasKategorieCollection() {
        return produktyHasKategorieCollection;
    }

    public void setProduktyHasKategorieCollection(Collection<ProduktyHasKategorie> produktyHasKategorieCollection) {
        this.produktyHasKategorieCollection = produktyHasKategorieCollection;
    }

    @XmlTransient
    public Collection<Adres> getAdresCollection() {
        return adresCollection;
    }

    public void setAdresCollection(Collection<Adres> adresCollection) {
        this.adresCollection = adresCollection;
    }

    @XmlTransient
    public Collection<FakturyHasProdukty> getFakturyHasProduktyCollection() {
        return fakturyHasProduktyCollection;
    }

    public void setFakturyHasProduktyCollection(Collection<FakturyHasProdukty> fakturyHasProduktyCollection) {
        this.fakturyHasProduktyCollection = fakturyHasProduktyCollection;
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
    public Collection<Transakcja> getTransakcjaCollection() {
        return transakcjaCollection;
    }

    public void setTransakcjaCollection(Collection<Transakcja> transakcjaCollection) {
        this.transakcjaCollection = transakcjaCollection;
    }

    @XmlTransient
    public Collection<Zamowienia> getZamowieniaCollection() {
        return zamowieniaCollection;
    }

    public void setZamowieniaCollection(Collection<Zamowienia> zamowieniaCollection) {
        this.zamowieniaCollection = zamowieniaCollection;
    }

    @XmlTransient
    public Collection<Dostawcy> getDostawcyCollection() {
        return dostawcyCollection;
    }

    public void setDostawcyCollection(Collection<Dostawcy> dostawcyCollection) {
        this.dostawcyCollection = dostawcyCollection;
    }

    @XmlTransient
    public Collection<Produkty> getProduktyCollection() {
        return produktyCollection;
    }

    public void setProduktyCollection(Collection<Produkty> produktyCollection) {
        this.produktyCollection = produktyCollection;
    }

    @XmlTransient
    public Collection<ProduktyHasZamowienia> getProduktyHasZamowieniaCollection() {
        return produktyHasZamowieniaCollection;
    }

    public void setProduktyHasZamowieniaCollection(Collection<ProduktyHasZamowienia> produktyHasZamowieniaCollection) {
        this.produktyHasZamowieniaCollection = produktyHasZamowieniaCollection;
    }

    @XmlTransient
    public Collection<Kategorie> getKategorieCollection() {
        return kategorieCollection;
    }

    public void setKategorieCollection(Collection<Kategorie> kategorieCollection) {
        this.kategorieCollection = kategorieCollection;
    }

    @XmlTransient
    public Collection<DaneFirmy> getDaneFirmyCollection() {
        return daneFirmyCollection;
    }

    public void setDaneFirmyCollection(Collection<DaneFirmy> daneFirmyCollection) {
        this.daneFirmyCollection = daneFirmyCollection;
    }

    @XmlTransient
    public Collection<TransakcjaHasProdukty> getTransakcjaHasProduktyCollection() {
        return transakcjaHasProduktyCollection;
    }

    public void setTransakcjaHasProduktyCollection(Collection<TransakcjaHasProdukty> transakcjaHasProduktyCollection) {
        this.transakcjaHasProduktyCollection = transakcjaHasProduktyCollection;
    }

    @XmlTransient
    public Collection<Regal> getRegalCollection() {
        return regalCollection;
    }

    public void setRegalCollection(Collection<Regal> regalCollection) {
        this.regalCollection = regalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produkt.User[ userId=" + userId + " ]";
    }
    
}
