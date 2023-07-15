package br.com.banco.data;

import java.io.Serializable;
import java.time.ZonedDateTime;

import br.com.banco.models.enums.TipoTransferencia;
import lombok.Data;

@Data
public class TransferenciaDto implements Serializable {
    private Long id;
    private ZonedDateTime dataTransferencia;
    private Float valor;
    private TipoTransferencia tipo;
    private String nomeOperadorTransacao;
}
