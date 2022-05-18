package com.example.fantaskbackend;

import com.example.fantaskbackend.controller.ItemRESTController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeItemRESTControllerTest {
    //https://spring.io/guides/gs/testing-web/

    @Autowired
    private ItemRESTController itemRESTController;

    @Test
    public void testItemController() {
        assertThat(itemRESTController).isNotNull();
    }
}
