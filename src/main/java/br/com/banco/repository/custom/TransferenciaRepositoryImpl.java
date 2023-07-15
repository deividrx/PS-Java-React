package br.com.banco.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import br.com.banco.models.Transferencia;
import br.com.banco.models.Transferencia_;

@Repository
public class TransferenciaRepositoryImpl implements CustomTransferenciaRepository {

    @Autowired
    private EntityManager em;

    public Float calcularSaldo(Specification<Transferencia> specification) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Float> cq = cb.createQuery(Float.class);
        Root<Transferencia> root = cq.from(Transferencia.class);

        cq.select(cb.sum(root.get(Transferencia_.valor)))
            .where(specification.toPredicate(root, cq, cb));

        TypedQuery<Float> tq = em.createQuery(cq);
        return tq.getSingleResult();
    }
}
