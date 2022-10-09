package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv4Repository {
    @PersistenceContext
    private EntityManager em;
    public Lv4 findOne(String keyword) {
        return em.find(Lv4.class, keyword);
    }
    public List<Lv4> findAllByLv4IdKeyword(String keyword) {
        return em.createQuery("select l from Lv4 l where l.id =: keyword", Lv4.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    public List<Lv4> findAllByLv3Id(String lv3Id) {
        return em.createQuery("""
                        select l4 from Lv4 l4
                        inner join Lv3 l3 on l4.lv3 = l3
                        where l3.id = :lv3Id
                        """, Lv4.class)
                .setParameter("lv3Id", lv3Id)
                .getResultList();
    }

    public List<Lv4> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("""
                        select l4 from Lv4 l4
                        inner join BodyInfo bi on l4.bodyInfo.id = bi.id
                        inner join Content c on c.bodyInfo.id = bi.id
                        where c.contentText like concat('%',:contentKeyword,'%')
                        """, Lv4.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }

}