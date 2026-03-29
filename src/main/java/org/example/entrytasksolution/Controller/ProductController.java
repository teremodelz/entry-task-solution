package org.example.entrytasksolution.Controller;

import lombok.RequiredArgsConstructor;
import org.example.entrytasksolution.DTOs.CreateProductDTO;
import org.example.entrytasksolution.DTOs.GetProductDTO;
import org.example.entrytasksolution.DTOs.UpdateProductDTO;
import org.example.entrytasksolution.Service.Interfaces.ProductService;
import org.example.entrytasksolution.Service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<GetProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping()
    public ResponseEntity<GetProductDTO> createProduct(
            @RequestBody CreateProductDTO createProductDTO){

        return ResponseEntity.ok(productService.createProduct(createProductDTO));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<GetProductDTO> updateProduct(
            @PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO){
        return ResponseEntity.ok(productService.updateProduct(id, updateProductDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
