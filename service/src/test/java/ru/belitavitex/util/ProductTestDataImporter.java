package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.ProductDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.ProductService;

/**
 * Created by Dzianis on 07.06.2017.
 */
@Repository
public class ProductTestDataImporter {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryDao categoryDao;

    public void importTestData() {
        Category category = new Category();
        category.setName("Бальзамы");
        categoryDao.save(category);

        Product balm = saveProduct("Бальзам для жирных волос",
                "Легчайшая формула бальзама, не содержащая масел, " +
                 "специально разработана для максимально эффективного ухода " +
                 "за жирными и быстро загрязняющимися волосами.",
                6, 100, category);
        Product shampoos = saveProduct("SPA – шампунь Минеральный",
                "Шампунь прекрасно очищает, не вымывая " +
                "естественную защиту волос, питает кожу головы. Помогает " +
                "оградить волосы от вредного воздействия окружающей среды.",
                5, 100,category);
        Product showerGels = saveProduct("ГЕЛЬ ДЛЯ ДУША АКВА-ДРЕНАЖ",
                "Инновационная формула геля для душа обеспечивает " +
                 "эффективное очищение кожи и подготовку к антицеллюлитным " +
                 "процедурам.", 9, 100, category);
    }

    private Product saveProduct(String name, String description, int price,
                                int residue, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setResidue(residue);
        product.setCategory(category);
        productService.save(product);
        return product;
    }
}
