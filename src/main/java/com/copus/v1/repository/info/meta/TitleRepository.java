package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.Title;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TitleRepository {
    private final EntityManager em;


    public List<Title> findTitleByMetaInfoId(Long metaInfoId) {
        return em.createQuery("""
                        select t from Title t
                        inner join TitleInfo ti on t.titleInfo = ti
                        inner join MetaInfo mi on ti.metaInfo = mi
                        where mi.id = :metaInfoId
                        """, Title.class)
                .setParameter("metaInfoId", metaInfoId)
                .getResultList();
    }

    //동일레벨

    public List<Title> findLv1TitleByLv1Id(String id) {
        return em.createQuery("select t from Title t join t.titleInfo ti " +
                        "where ti.metaInfo = (select l.metaInfo from Lv1 l where l.id = :id)", Title.class)
                .setParameter("id", id)
                .getResultList();
    }

}

