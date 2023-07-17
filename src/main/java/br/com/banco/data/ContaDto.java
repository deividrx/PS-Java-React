package br.com.banco.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContaDto implements Serializable {

    private Long id;
    private String nomeResponsavel;
    private Float saldoTotal;
}
