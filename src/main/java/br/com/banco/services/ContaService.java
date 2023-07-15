package br.com.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.repository.filters.TransferenciaFilter;

@Service
public class ContaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public Float calcularSaldoTotal(Long contaId) {
        var filter = new TransferenciaFilter();
        return transferenciaRepository.calcularSaldo(filter.filterByConta(contaId));
    }

    // public Page<?> list
}
