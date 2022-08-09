package com.ismael.Springbootrestdeploy.controller;

import com.ismael.Springbootrestdeploy.repository.LaptopRepository;
import com.ismael.Springbootrestdeploy.entities.Laptop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    // atributos

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    LaptopRepository laptopRepository;


    @Value("${app.message}")
    private	String message;







    // constructor: solo se crea un constructor para poder pasarle
    // el bean LaptopRepository no dos, solo dos en la entidad.


    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }





// CRUD sobre entidad Laptop

    // Busscar todos los Laptops

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        System.out.println(message);


        // recuperar los Laptops de la base de datos y devolverlos
        return laptopRepository.findAll();
    }



    // Buscar un Laptop en base de datos según su id

   // @ApiOperation("Método para buscar un libro por clave primaria tipo Long id")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById( @PathVariable Long id){

          Optional<Laptop> laptopOpc = laptopRepository.findById(id);

          if(laptopOpc.isPresent())
              return ResponseEntity.ok(laptopOpc.get());
          else
              return ResponseEntity.notFound().build();

    }

    // crear un nuevo Laptop en base de datos desde postman
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop,@RequestHeader HttpHeaders headers){

        // obtener información de las cabeceras para saver de donde envian la petición Http
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() != null) { // quiere decir que el id ya existe y por tanto no es una creación
            log.warn("trying to create a Laptop with id");
            System.out.println("trying to create a Laptop with id");
            return ResponseEntity.badRequest().build();

        }

        // Guardar el libro recibido por parámetros en base de datos
      Laptop result =  laptopRepository.save(laptop);

        return ResponseEntity.ok(result);
    }


    // actualizar un Laptop existente en base de datos
    
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop ){
        
        if(laptop.getId() == null) { // si no tiene id quiere decir que si es una creación
            log.warn("trying to update a non existent laptop");
            System.out.println("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }

        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("tryin to update a non existent lapto");
            System.out.println("trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }


        // el proceso de actualización
       Laptop result =  laptopRepository.save(laptop);

        return ResponseEntity.ok(result);
    }




    // borrar un libro en base de datos

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("trying to delete a non existent laptop");
                    return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();


    }


    // borrar todos los libros de la base de datos

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){

        log.info("Rest request for delete all laptops");

        laptopRepository.deleteAll();

        return ResponseEntity.noContent().build();

    }
}
