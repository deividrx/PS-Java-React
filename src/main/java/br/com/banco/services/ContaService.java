package br.com.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.banco.data.ContaDto;
import br.com.banco.data.mappers.ContaMapper;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.repository.filters.TransferenciaFilter;

@Service
public class ContaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaMapper contaMapper;

    private Float calcularSaldoTotal(Long contaId) {
        var filter = new TransferenciaFilter();
        return transferenciaRepository.calcularSaldo(filter.filterByConta(contaId));
    }

    public Page<ContaDto> listConta(Pageable pageable) {
        return contaRepository.findAll(pageable).map(
                conta -> {
                    var dto = contaMapper.map(conta);
                    dto.setSaldoTotal(calcularSaldoTotal(conta.getId()));
                    return dto;
                });
    }
}
