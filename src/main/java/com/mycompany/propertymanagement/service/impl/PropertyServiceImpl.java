package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dataTransferObjects.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
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
}
