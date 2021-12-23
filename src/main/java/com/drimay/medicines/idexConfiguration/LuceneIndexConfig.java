/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.idexConfiguration;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author jaime
 */
public class LuceneIndexConfig {

    @Bean
    public LuceneIndexServiceBean luceneIndexServiceBean(EntityManagerFactory EntityManagerFactory){
        LuceneIndexServiceBean luceneIndexServiceBean = new LuceneIndexServiceBean(EntityManagerFactory);
        luceneIndexServiceBean.triggerIndexing();
        return luceneIndexServiceBean;
    }

}
