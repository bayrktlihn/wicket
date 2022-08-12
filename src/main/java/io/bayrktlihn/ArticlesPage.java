package io.bayrktlihn;


import java.math.BigDecimal;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.ExternalImage;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import io.bayrktlihn.entities.Article;

public class ArticlesPage extends BaseEntitiesPage {

  private DataView<Article> articlesDataView;

  private Form form;

  public ArticlesPage(PageParameters parameters) {
    super(parameters);
  }

  @Override
  protected void onInitialize() {

    articlesDataView = new DataView<Article>("articles", new ArticlesDataProvider()) {

      @Override
      protected void populateItem(Item<Article> item) {
        Article article = item.getModelObject();
        item.setModel(new CompoundPropertyModel<>(article));
        item.add(new Label("name"));
        item.add(new Label("category.name"));
        item.add(new Label("description"));
        item.add(new Label("price"));
        item.add(new ExternalImage("image", article.getImageUrl()));
        item.add(new Label("validFrom"));
        item.add(new Label("validTo"));
      }

    };

    initializeForm();

    add(articlesDataView);
    add(form);
    super.onInitialize();
  }

  private void initializeForm() {

    TextField<String> nameTextField = new TextField<String>("name");
    TextField<String> descriptionTextField = new TextField<>("description");
    NumberTextField<BigDecimal> priceNumberTextField = new NumberTextField<BigDecimal>("price");
    DateTextField validFromDateTextField = new DateTextField("validFrom");
    DateTextField validToDateTextField = new DateTextField("validTo");
    TextField<String> imageUrlTextField = new TextField<>("imageUrl");

    form = new Form<>("form");
    form.setVisible(false);
    form.add(nameTextField);
    form.add(descriptionTextField);


  }

  @Override
  protected IPageable getPageable() {
    return articlesDataView;
  }

}
