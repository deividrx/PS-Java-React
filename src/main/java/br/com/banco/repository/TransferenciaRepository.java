package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.models.Transferencia;
import br.com.banco.repository.custom.CustomTransferenciaRepository;

@Repository
public interface TransferenciaRepository
        extends JpaRepository<Transferencia, Long>, JpaSpecificationExecutor<Transferencia>,
        CustomTransferenciaRepository {
}
