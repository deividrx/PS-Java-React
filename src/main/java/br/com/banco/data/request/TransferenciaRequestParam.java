package br.com.banco.data.request;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TransferenciaRequestParam implements Serializable {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dataInicio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dataFim;
    private String operador;

    public boolean hasDataInicio() {
        return dataInicio != null;
    }

    public boolean hasDataFim() {
        return dataFim != null;
    }

    public boolean hasOperador() {
        return operador != null;
    }

}
