package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.domain.Product;

import java.util.List;

@RestController
@RequestMapping("api") /*wszystkie metody będą miały przedrostek*/
@CrossOrigin /*wyłączenie metod bezpiueczeństwa. Jeśli klient pyta serwer to musi pochodzić z tej samej domeny, jeśli jest z innej to go wyrzuci*/
public class RestShopController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("products")
    public List<Product> products() {
        return productDao.getProducts();
    }

    @DeleteMapping("products/remove/{id}")
    public void removeProduct(@PathVariable Long id) {
        productDao.removeProduct(id);
    }

}
