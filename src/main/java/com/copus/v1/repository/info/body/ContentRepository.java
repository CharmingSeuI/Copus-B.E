package com.copus.v1.repository.info.body;

import com.copus.v1.domain.info.body.Content;
import com.copus.v1.domain.level.Lv4;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Content> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("select c from Content c where c.contentText like concat('%',:contentKeyword,'%') ", Content.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }

    public List<Content> findOneByBodyInfoId(Long bodyInfoId) {
        return em.createQuery("select c from Content c " +
                        "where c.bodyInfo.id = :bodyInfoId", Content.class)
                .setParameter("bodyInfoId", bodyInfoId)
                .getResultList();
    }
}


