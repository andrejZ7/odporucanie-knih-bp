
package com.andrej.nacitaniedat.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andrej
 */

@Entity
@Table(name = "kniha")
public class Kniha implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String isbn;
    private String autor;
    private String vydavatelstvo;

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
    
}