package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dataTransferObjects.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private PropertyConverter converter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity entity = converter.convertDTOToEntity(propertyDTO);
        entity = repository.save(entity);

        propertyDTO = converter.convertEntityToDTO(entity);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        System.out.println("Inside service " + dummy);

        System.out.println("Inside service " + dbUrl);

        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        List<PropertyEntity> listOfProps = (List<PropertyEntity>) repository.findAll();

        for (PropertyEntity propertyEntity : listOfProps) {
            PropertyDTO propertyDTO = converter.convertEntityToDTO(propertyEntity);
            propertyDTOList.add(propertyDTO);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEntity = repository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEntity.isPresent()) {

            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());
            dto = converter.convertEntityToDTO(propertyEntity);

            repository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEntity = repository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEntity.isPresent()) {

            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());

            dto = converter.convertEntityToDTO(propertyEntity);

            repository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEntity = repository.findById(propertyId);
        PropertyDTO dto = null;
        if (optEntity.isPresent()) {

            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setPrice(propertyDTO.getPrice());

            dto = converter.convertEntityToDTO(propertyEntity);

            repository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        repository.deleteById(propertyId);
    }
}
