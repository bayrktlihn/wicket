package io.bayrktlihn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import io.bayrktlihn.entities.Category;
import io.bayrktlihn.services.CategoryService;
import io.bayrktlihn.services.ServiceRegistry;

public class CategoriesDataProvider extends SortableDataProvider<Category, String> {

  public CategoriesDataProvider() {
    setSort("name", SortOrder.ASCENDING);
  }

  @Override
  public Iterator<? extends Category> iterator(long first, long count) {
    Collection<Category> categoryCollection = ServiceRegistry.get(CategoryService.class).listAll();
    List<Category> categoryList = new ArrayList<>(categoryCollection);

    SortParam<String> sortParam = getSort();

    categoryList.sort((c1, c2) -> {
      String c1Name = c1.getName();
      String c2Name = c2.getName();
      return sortParam.isAscending() ? c1Name.compareTo(c2Name) : c2Name.compareTo(c1Name);
    });



    List<Category> categorySubList = categoryList.subList((int) first, (int) (first + count >= categoryList.size() ? categoryList.size() : first + count));
    return categorySubList.iterator();
  }

  @Override
  public long size() {
    Collection<Category> categoryCollection = ServiceRegistry.get(CategoryService.class).listAll();
    return categoryCollection.size();
  }

  @Override
  public IModel<Category> model(Category category) {
    return new CompoundPropertyModel<>(new EntityModel<>(category, CategoryService.class));
  }

}
