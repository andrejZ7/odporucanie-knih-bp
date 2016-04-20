
package com.andrej.nacitaniedat.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andrej
 */

@Entity
@Table(name = "knihaPomocna")
public class KnihaPomocna implements Serializable {
    
    @OneToMany(mappedBy="kniha", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Mdt> MdtList;
    
    @Id
    @GeneratedValue
    private Integer id;
    private String isbn;
    private String autor;
    private String vydavatelstvo;
    private String datum;
    private String klucoveSlova;
    
    @ManyToMany
    private List<Kniha> pouzivatel;

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the vydavatelstvo
     */
    public String getVydavatelstvo() {
        return vydavatelstvo;
    }

    /**
     * @param vydavatelstvo the vydavatelstvo to set
     */
    public void setVydavatelstvo(String vydavatelstvo) {
        this.vydavatelstvo = vydavatelstvo;
    }

    /**
     * @return the MdtList
     */
    public List<Mdt> getMdtList() {
        return MdtList;
    }

    /**
     * @param MdtList the MdtList to set
     */
    public void setMdtList(List<Mdt> MdtList) {
        this.MdtList = MdtList;
    }

    /**
     * @return the datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }

    /**
     * @return the klucoveSlova
     */
    public String getKlucoveSlova() {
        return klucoveSlova;
    }

    /**
     * @param klucoveSlova the klucoveSlova to set
     */
    public void setKlucoveSlova(String klucoveSlova) {
        this.klucoveSlova = klucoveSlova;
    }

    /**
     * @return the pouzivatel
     */
    public List<Kniha> getPouzivatel() {
        return pouzivatel;
    }

    /**
     * @param pouzivatel the pouzivatel to set
     */
    public void setPouzivatel(List<Kniha> pouzivatel) {
        this.pouzivatel = pouzivatel;
    }
    
}
