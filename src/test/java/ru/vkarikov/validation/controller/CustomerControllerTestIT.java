package ru.vkarikov.validation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ru.vkarikov.validation.entity.Customer;

import static org.springframework.test.web.reactive.server.WebTestClient.bindToServer;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTestIT {

    @Autowired
    private CustomerController customerController;

    @LocalServerPort
    int port;

    @Test
    void name() throws Exception {

        System.out.println("Port " + port);

        WebTestClient client =
                WebTestClient.bindToServer().baseUrl("http://localhost:" + port)
                        .build();

        client.post().uri("/customers")
                .body(Mono.just(createCustomer()), Customer.class)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.errors[:1].defaultMessage").isEqualTo("INN is mandatory");
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setInn("");
        return customer;
    }
}