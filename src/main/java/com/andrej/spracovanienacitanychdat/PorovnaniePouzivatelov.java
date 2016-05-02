package com.andrej.spracovanienacitanychdat;

import com.andrej.nacitaniedat.PersistenceManager;
import com.andrej.nacitaniedat.model.Kniha;
import com.andrej.nacitaniedat.model.Pouzivatel;
import com.andrej.spracovaniedat.DataLoaderServices;
import com.andrej.spracovaniedat.PodobnyPouzivatel;
import com.andrej.spracovaniedat.UserServices;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;

/**
 *
 * @author andrej
 */
public class PorovnaniePouzivatelov {
    
    public static void main(String [] args) {
        
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        DataLoaderServices dataLoader = new DataLoaderServices();
        UserServices userService = new UserServices();
        List<Pouzivatel> pouzivateliaList = userService.nacitajVsetkychPouzivatelov(em);
        int pocitadlo = 0;
        Pouzivatel userA = null;
        Pouzivatel userB = null;
        int vsetciPouzivatelia = pouzivateliaList.size();
        PodobnyPouzivatel podobnost = new PodobnyPouzivatel();
        double maxPodobnost = 0;
        double aktualnaPodobnost;
        Integer maxPodobnyPouzivatelId = 0;
        Pouzivatel podobniPouzivatel = new Pouzivatel();
        
        for(int i=0 ; i<vsetciPouzivatelia ; i++){
            System.out.println(pocitadlo + ". *****************************************************************");
            pocitadlo++;
            maxPodobnost = 0;
            userA = pouzivateliaList.get(i);
            for(int j=0 ; j<vsetciPouzivatelia ; j++){ 
                userB = pouzivateliaList.get(j);
                if(i != j){
                    podobnost = userService.porovnajPouzivatelov(userA, userB, j);                    
                }
                aktualnaPodobnost = podobnost.getPodobnost();
                if (aktualnaPodobnost > maxPodobnost) {
                    maxPodobnost = aktualnaPodobnost;
                    maxPodobnyPouzivatelId = podobnost.getPouzivatel().getId();
                    podobniPouzivatel = podobnost.getPouzivatel();
                }
            }
            /*System.out.println("Najpodobnejsi pouzivatel k pouzivatelovi " + userA.getId() + 
                               " je " + maxPodobnyPouzivatelId + " *** Podobnost: " +maxPodobnost +
                               "/////////////////////////// " + podobniPouzivatel.getId());*/
            
            userA.setNajblizsiPouzivatel(podobniPouzivatel);
            podobniPouzivatel.getPodobniPouzivatelia().add(userA);
            
            em.getTransaction()
              .begin();
            em.merge(userA);
            em.merge(podobniPouzivatel);
            em.flush();                                                        
            em.getTransaction()
              .commit();            
        }
        
        em.close();
        PersistenceManager.INSTANCE.close();
       
    }
}
