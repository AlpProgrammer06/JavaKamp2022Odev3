package Busines;

import DataAccsses.CategoryDao;
import Entities.Category;
import Logging.Logger;

import java.util.List;

public class CategoryManager {
    private CategoryDao categoryDao;
    private  Logger[] loggers;
    private final List<Category> categories;


    public CategoryManager(CategoryDao categoryDao, Logger[] loggers, List<Category> categories) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }
    public void add(Category category) throws Exception{
        for(Category categories : categories){
            if (categories.getCategoryName()==category.getCategoryName()){
                throw  new Exception("Aynı kategori ismi kullanılamaz");
            }
        }
        categoryDao.add(category);

    }
}

