package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dataTransferObjects.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/Marhaba")
    public String sayHello() {
        return "Marhaba";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

        return responseEntity;
    }
}
