package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dataTransferObjects.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO) {

        PropertyEntity entity = new PropertyEntity();
        entity.setTitle(propertyDTO.getTitle());
        entity.setDescription(propertyDTO.getDescription());
        entity.setOwnerName(propertyDTO.getOwnerName());
        entity.setOwnerEmail(propertyDTO.getOwnerEmail());
        entity.setPrice(propertyDTO.getPrice());
        entity.setAddress(propertyDTO.getAddress());

        return entity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity entity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(entity.getId());
        propertyDTO.setTitle(entity.getTitle());
        propertyDTO.setDescription(entity.getDescription());
        propertyDTO.setOwnerName(entity.getOwnerName());
        propertyDTO.setOwnerEmail(entity.getOwnerEmail());
        propertyDTO.setPrice(entity.getPrice());
        propertyDTO.setAddress(entity.getAddress());

        return propertyDTO;
    }
}
