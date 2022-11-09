package isil.pe.springdatajpa.service;

import isil.pe.springdatajpa.entity.Category;
import isil.pe.springdatajpa.entity.Customer;
import isil.pe.springdatajpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){

        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent())
        {
            return category.get();
        } else
        {
            return null;
        }
    }
}
