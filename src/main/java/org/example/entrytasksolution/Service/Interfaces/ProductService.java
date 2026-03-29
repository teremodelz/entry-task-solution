package org.example.entrytasksolution.Service.Interfaces;

import org.example.entrytasksolution.DTOs.CreateProductDTO;
import org.example.entrytasksolution.DTOs.GetProductDTO;
import org.example.entrytasksolution.DTOs.UpdateProductDTO;

import java.util.List;

public interface ProductService {
    List<GetProductDTO> getAllProducts();
    GetProductDTO createProduct(CreateProductDTO createProductDTO);
    GetProductDTO updateProduct(Long id, UpdateProductDTO updateProductDTO);
    String deleteProduct(Long id);
}
