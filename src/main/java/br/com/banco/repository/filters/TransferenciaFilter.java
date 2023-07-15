package br.com.banco.repository.filters;

import java.time.ZonedDateTime;

import org.springframework.data.jpa.domain.Specification;

import br.com.banco.models.Conta_;
import br.com.banco.models.Transferencia;
import br.com.banco.models.Transferencia_;

public class TransferenciaFilter {

    public Specification<Transferencia> filterByDataInicial(ZonedDateTime data) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(Transferencia_.dataTransferencia), data);
        };
    }

    public Specification<Transferencia> filterByDataFinal(ZonedDateTime data) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get(Transferencia_.dataTransferencia), data);
        };
    }

    public Specification<Transferencia> filterByOperador(String operador) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            var attr = criteriaBuilder.lower(root.get(Transferencia_.nomeOperadorTransacao));
            var param = String.format("%%%s%%", operador.toLowerCase());
            return criteriaBuilder.like(attr, param);
        };
    }

    public Specification<Transferencia> filterByConta(Long contaId) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            var attr = root.get(Transferencia_.conta).get(Conta_.id);
            return criteriaBuilder.equal(attr, contaId);
        };
    }
}
