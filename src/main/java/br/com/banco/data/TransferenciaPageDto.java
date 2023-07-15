package br.com.banco.data;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferenciaPageDto implements Serializable {

    private Page<TransferenciaDto> page;
    private Float saldoPeriodo;
}
