package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.data.ContaDto;
import br.com.banco.data.TransferenciaPageDto;
import br.com.banco.data.request.TransferenciaRequestParam;
import br.com.banco.services.ContaService;
import br.com.banco.services.TransferenciaService;

@RestController
@RequestMapping("/conta")
public class ContaRest {

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private ContaService contaService;

    @GetMapping(value = "/{id}/transferencias")
    public TransferenciaPageDto getListTransferencia(@PathVariable("id") Long contaId, Pageable pageable,
            TransferenciaRequestParam params) {
        return transferenciaService.list(contaId, pageable, params);
    }

    @GetMapping
    public Page<ContaDto> getListConta(Pageable pageable) {
        return contaService.listConta(pageable);
    }
}
