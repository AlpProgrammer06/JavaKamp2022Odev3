package DataAccsses;

import Entities.Category;

public class JdbcCategoryDao implements CategoryDao{
    @Override
    public void add(Category category) {
        System.out.println("Jdbc ile eklendi. " + category.getCategoryName() );
    }
}
