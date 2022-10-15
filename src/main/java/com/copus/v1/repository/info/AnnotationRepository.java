package com.copus.v1.repository.info;

import com.copus.v1.domain.info.Annotation;

import com.copus.v1.domain.info.AnnotationInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class AnnotationRepository {
    @PersistenceContext
    private EntityManager em;
    public List<Annotation> findOneByAnnotationInfoId(Long annotation_info_id) {
        return em.createQuery("select a from Annotation a " +
                        "where a.annotationInfo.id = :annotation_info_id", Annotation.class)
                .setParameter("annotation_info_id", annotation_info_id)
                .getResultList();
    }

}
