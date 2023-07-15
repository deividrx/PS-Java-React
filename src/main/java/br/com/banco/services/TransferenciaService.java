package br.com.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.banco.data.TransferenciaDto;
import br.com.banco.data.TransferenciaPageDto;
import br.com.banco.data.mappers.TransferenciaMapper;
import br.com.banco.data.request.TransferenciaRequestParam;
import br.com.banco.models.Transferencia;
import br.com.banco.repository.FilterBuilder;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.repository.filters.TransferenciaFilter;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private TransferenciaMapper transferenciaMapper;

    public TransferenciaPageDto list(Long contaId, Pageable pageable, TransferenciaRequestParam params) {
        TransferenciaFilter filter = new TransferenciaFilter();
        FilterBuilder<Transferencia> builder = new FilterBuilder<>();

        builder.add(filter.filterByConta(contaId));

        if (params.hasOperador())
            builder.add(filter.filterByOperador(params.getOperador()));
        if (params.hasDataFim())
            builder.add(filter.filterByDataFinal(params.getDataFim()));
        if (params.hasDataInicio())
            builder.add(filter.filterByDataInicial(params.getDataInicio()));

        var spec = builder.build();
        Page<TransferenciaDto> page = transferenciaRepository.findAll(spec, pageable).map(
                trans -> transferenciaMapper.map(trans));

        var saldo = transferenciaRepository.calcularSaldo(spec);
        return new TransferenciaPageDto(page, saldo);
    }
}
