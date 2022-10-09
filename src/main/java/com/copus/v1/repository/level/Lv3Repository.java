package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv3;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv3Repository {
    @PersistenceContext
    private EntityManager em;
    public Lv3 findOne(String keyword) {
        return em.find(Lv3.class, keyword);
    }

    public List<Lv3> findAllByLv2Id(String lv2Id) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join Lv2 l2 on l3.lv2 = l2
                        where l2.id = :lv2Id
                        """, Lv3.class)
                .setParameter("lv2Id", lv2Id)
                .getResultList();
    }

    public List<Lv3> findAllByLv4IdKeyword(String lv4IdKeyword) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join Lv4 l4 on l4.lv3 = l3
                        where l4.id = :keyword
                        """, Lv3.class)
                .setParameter("keyword", lv4IdKeyword)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv3TitleKeyword(String level_3_TitleKeyword) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join TitleInfo ti on ti.metaInfo = l3.metaInfo
                        inner join Title t on t.titleInfo.id = ti.id
                        where t.titleText like concat('%',:level_3_TitleKeyword,'%')
                        """, Lv3.class)
                .setParameter("level_3_TitleKeyword", level_3_TitleKeyword)
                .getResultList();
    }

    public List<Lv3> findAllByLv3IdKeyword(String keyword) {
        return em.createQuery("select l from Lv3 l where l.id =: keyword", Lv3.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

}
