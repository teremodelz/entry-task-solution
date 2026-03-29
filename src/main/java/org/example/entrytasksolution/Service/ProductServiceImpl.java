package org.example.entrytasksolution.Service;

import lombok.RequiredArgsConstructor;
import org.example.entrytasksolution.DTOs.CreateProductDTO;
import org.example.entrytasksolution.DTOs.GetProducerDetailsDTO;
import org.example.entrytasksolution.DTOs.GetProductDTO;
import org.example.entrytasksolution.DTOs.UpdateProductDTO;
import org.example.entrytasksolution.Entity.Producer;
import org.example.entrytasksolution.Entity.Product;
import org.example.entrytasksolution.Repository.ProducerRepository;
import org.example.entrytasksolution.Repository.ProductRepository;
import org.example.entrytasksolution.Service.Interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProducerRepository producerRepository;
    private final ProductRepository productRepository;

    @Override
    public List<GetProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapGetProductDTO)
                .toList();
    }

    @Override
    public GetProductDTO createProduct(CreateProductDTO createProductDTO) {
        Producer producer = producerRepository.findById(createProductDTO.getProducerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer with this ID doesn't exist."));

        Product product = Product.builder()
                .name(createProductDTO.getName())
                .attributes(createProductDTO.getAttributes())
                .producer(producer)
                .build();

        Product productToReturn = productRepository.save(product);

        return mapGetProductDTO(productToReturn);
    }

    @Override
    public GetProductDTO updateProduct(Long id, UpdateProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producer with this ID doesn't exist."));

        if (dto.getName() != null) {
            product.setName(dto.getName());
        }
        if (dto.getAttributes() != null) {
            product.setAttributes(dto.getAttributes());
        }
        if (dto.getProducerId() != null) {
            Producer producer = producerRepository.findById(dto.getProducerId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Producer with this ID doesn't exist."));
            product.setProducer(producer);
        }

        Product savedProduct = productRepository.save(product);
        return mapGetProductDTO(savedProduct);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow( () -> new ResponseStatusException
                (HttpStatus.NOT_FOUND, "Producer with this ID doesn't exist."));
        productRepository.delete(product);
        return String.format("Produkt with id %s has been deleted.", id);
    }


    //Mappers
    private GetProducerDetailsDTO mapToGetProducerDetailsDTO(Producer producer){
        return new GetProducerDetailsDTO(producer.getId(), producer.getName(),producer.getSupportMail());
    }
    private GetProductDTO mapGetProductDTO(Product product){
        GetProducerDetailsDTO producer = mapToGetProducerDetailsDTO(product.getProducer());
        return new GetProductDTO(product.getId(), product.getName(), product.getAttributes(), producer);
    }

}
