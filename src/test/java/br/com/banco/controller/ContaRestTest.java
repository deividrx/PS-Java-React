package br.com.banco.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ContaRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetListConta() throws Exception {
        mockMvc.perform(get("/conta"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].id").isNotEmpty())
                .andExpect(jsonPath("$.content[1].nomeResponsavel").value("Sicrano"))
                .andExpect(jsonPath("$.content[1].saldoTotal").value(24654.83));
    }

    @Test
    void testGetListTransferenciaWithoutParams() throws Exception {
        mockMvc.perform(get("/conta/2/transferencias"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page.content[*].id").isNotEmpty())
                .andExpect(jsonPath("$.saldoPeriodo").value(24654.83));
    }

    @Test
    void testGetListTransferenciaWithoutParamsEmpty() throws Exception {
        mockMvc.perform(get("/conta/3/transferencias"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page.content[*].id").isEmpty())
                .andExpect(jsonPath("$.saldoPeriodo").isEmpty());
    }

    @Test
    void testGetListTransferenciaOperador() throws Exception {
        mockMvc.perform(get("/conta/2/transferencias")
                .param("operador", "Ronnyscley"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page.content[*].id").isNotEmpty())
                .andExpect(jsonPath("$.saldoPeriodo").value(25173.09));
    }

    @Test
    void testGetListTransferenciaDate() throws Exception {
        mockMvc.perform(
                get("/conta/2/transferencias")
                        .param("dataInicio", ZonedDateTime.now().toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page.content[*].id").isEmpty())
                .andExpect(jsonPath("$.saldoPeriodo").isEmpty());
    }
}
