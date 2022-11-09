package isil.pe.springdatajpa.service;

import isil.pe.springdatajpa.entity.Category;
import isil.pe.springdatajpa.entity.Item;
import isil.pe.springdatajpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(Long id){

        Optional<Item> item = itemRepository.findById(id);

        if(item.isPresent())
        {
            return item.get();
        } else
        {
            return null;
        }
    }
}
