package io.bayrktlihn;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.ExternalImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.UrlValidator;
import io.bayrktlihn.entities.Category;
import io.bayrktlihn.services.CategoryService;
import io.bayrktlihn.services.ServiceRegistry;
import lombok.Getter;

@Getter
public class CategoriesPage extends BaseEntitiesPage {

  private DataView<Category> categoryDataView;
  private ISortableDataProvider<Category, String> dataProvider;
  private Link<String> newCategoryLink;
  private Form<Category> form;
  private EntityModel<Category, CategoryService> formEntityModel = new EntityModel<>(CategoryService.class);

  public CategoriesPage(PageParameters parameters) {
    super(parameters);

    dataProvider = new CategoriesDataProvider();

    form = new Form<Category>("form") {
      @Override
      protected void onSubmit() {
        super.onSubmit();
        ServiceRegistry.get(CategoryService.class).save(getModelObject());
        form.setVisible(false);
      }
    };



    categoryDataView = new DataView<Category>("categories", dataProvider) {

      @Override
      protected void populateItem(Item<Category> item) {
        Category category = item.getModelObject();
        item.add(new Label("name"));
        item.add(new ExternalImage("image", new PropertyModel<>(new EntityModel<>(category, CategoryService.class), "imageUrl")));
      }

    };



  }

  @Override
  protected void onInitialize() {
    super.onInitialize();

    categoryDataView.setItemsPerPage(3);
    newCategoryLink = new Link<String>("newCategory") {
      @Override
      public void onClick() {
        form.setVisible(true);
        formEntityModel.setObject(new Category());
      }
    };
    add(newCategoryLink);
    add(categoryDataView);
    add(new OrderByBorder<>("orderByName", "name", dataProvider));


    initializeForm();
    add(form);



  }

  private void initializeForm() {
    TextField<String> nameTextField = new TextField<>("name");
    TextField<String> imageUrlTextField = new TextField<>("imageUrl");

    nameTextField.setRequired(true);
    imageUrlTextField.setRequired(true).add(new UrlValidator());

    add(new FeedbackPanel("feedback"));
    form.setModel(new CompoundPropertyModel<Category>(formEntityModel));

    form.add(nameTextField);
    form.add(imageUrlTextField);

    form.setVisible(false);


  }

  @Override
  protected IPageable getPageable() {
    return categoryDataView;
  }

}
