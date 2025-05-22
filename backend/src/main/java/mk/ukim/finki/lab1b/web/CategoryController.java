package mk.ukim.finki.lab1b.web;

import mk.ukim.finki.lab1b.model.Enumerations.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public Category[] getAllCategories() {
        return Category.values();
    }
}
