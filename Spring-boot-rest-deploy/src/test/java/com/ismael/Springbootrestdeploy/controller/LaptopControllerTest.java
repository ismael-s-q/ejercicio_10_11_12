package com.ismael.Springbootrestdeploy.controller;

import com.ismael.Springbootrestdeploy.entities.Laptop;
import com.ismael.Springbootrestdeploy.repository.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {



        private TestRestTemplate testRestTemplate;

        @Autowired
        private RestTemplateBuilder restTemplateBuilder;
        @LocalServerPort
        private int port;







        @BeforeEach
        void setUp() {
            restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);

            testRestTemplate = new TestRestTemplate(restTemplateBuilder);



        }


//
//        @Test
//    void findAll() {
//
//            ResponseEntity<Laptop[]> response =
//                    testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
//
//
//            assertEquals(HttpStatus.OK,response.getStatusCode());
//            assertEquals(200,response.getStatusCodeValue());
//
//            List<Laptop> laptops = Arrays.asList(response.getBody());
//            System.out.println(laptops.size());
//
//        }
//
//
//        @Test
//        void hello(){
//
//
//            ResponseEntity<String> response =
//                    testRestTemplate.getForEntity("/hola",String.class);
//
//            assertEquals( HttpStatus.OK ,response.getStatusCode());
//            assertEquals( "¡¡ Hola mundo!!!" ,response.getBody());
//
//
//        }
//
//
//    @Test
//    void findOneById() {
//
//        ResponseEntity<Laptop> response =
//                testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
//
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//
//       Laptop result = response.getBody();
//
//
//        System.out.println(result);
//
//    }
//
//
//
//
//
//    @Test
//    void create() {
//
//        // Crear las cabezeras
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        // crear Json
//
//        String jSon = """
//            {
//                    "model": "php",
//                    "tamaño": 15,
//                    "colour": "amarillo"
//                }
//            """;
//
//        // preparar las peticiones
//
//        HttpEntity<String> request = new HttpEntity<>(jSon,headers);
//
//        ResponseEntity<Laptop> response =
//                testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
//
//
//        Laptop result =  response.getBody();
//
//        // ejecutar asserciones
//        assertEquals("amarillo",result.getColour());
//        assertEquals(1L,result.getId());
//
//
//    }
//
//
//
////    @Test
////    void update() {
////
////
////        ResponseEntity<Laptop>    response =
////                testRestTemplate.getForEntity("/api/laptops",Laptop.class);
////
////
////    }
//
////    @Test
////    void delete() {
////
////
////        ResponseEntity<Laptop> response =
////                testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
////
////
////        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode() );
////
////       Laptop result = response.getBody();
////
////        System.out.println(result);
////
////
////    }
//
//    @Test
//    void deleteAll() {
//
//
//        ResponseEntity<Laptop[]> response =
//                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
//
//
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//        assertEquals(200,response.getStatusCodeValue());
//
//        List<Laptop> laptops = Arrays.asList(response.getBody());
//        System.out.println(laptops.size());
//
//
//
//    }
}