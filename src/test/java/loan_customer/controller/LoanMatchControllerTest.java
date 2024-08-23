package loan_customer.controller;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.util.ReadJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class LoanMatchControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CustomerRequest> requestJson;

    CustomerRequest request;


    @BeforeEach
    void setUp() {
        request = new CustomerRequest("Ericka", "12345678910", 30, "SP", 3000.0);
    }

    @Test
    @DisplayName("deve retornar erro BadRequest por faltar a request da requisição")
    void loanMatchError400NoContent() throws Exception {

        var atual = mvc.perform(post("/v1/loan")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse();

        assertThat(atual.getStatus()).isEqualTo(BAD_REQUEST.value());
    }

    @Test
    @DisplayName("deve retornar somente o emprestimo de personal")
    void loanMatch() throws Exception {

        var atual = mvc.perform(post("/v1/loan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson.write(request).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().json(ReadJson.execute("json/personal.json")))
                .andReturn().getResponse();

        assertThat(atual.getStatus()).isEqualTo(OK.value());
    }
}