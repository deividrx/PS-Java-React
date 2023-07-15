package br.com.banco.repository.custom;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.banco.models.Transferencia;

@NoRepositoryBean
public interface CustomTransferenciaRepository {
    Float calcularSaldo(Specification<Transferencia> specification);
}
