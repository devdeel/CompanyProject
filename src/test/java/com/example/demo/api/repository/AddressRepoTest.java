package com.example.demo.api.repository;

import com.example.demo.model.entity.Address;
import com.example.demo.repository.AddressRepo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class AddressRepoTest {

    @Autowired
    private AddressRepo addressRepo;

    @Test
    public void testSaveAddress() {
         Address address = Address.builder()
                 .city("Riyadh")
                 .streetName("King Saud Road")
                 .zipCode("3333")
                 .build();


         Address savedAddress = addressRepo.save(address);

        assertThat(savedAddress.getId()).isNotNull();

        assertThat(savedAddress.getCity())
                .isEqualTo("Riyadh");
        assertThat(savedAddress.getStreetName())
                .isEqualTo("King Saud Road");
        assertThat(savedAddress.getZipCode())
                .isEqualTo("3333");    }

}
