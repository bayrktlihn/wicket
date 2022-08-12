package io.bayrktlihn;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import io.bayrktlihn.entities.Table;

public class TablesPage extends BaseEntitiesPage {

  DataView<Table> tablesDataView;

  public TablesPage(PageParameters parameters) {
    super(parameters);
  }

  @Override
  protected void onInitialize() {

    tablesDataView = new DataView<Table>("tables", new TablesDataProvider()) {

      @Override
      protected void populateItem(Item<Table> item) {
        Table table = item.getModelObject();

        item.add(new Label("name", table.getName()));
        item.add(new Label("seatCount", table.getSeatCount()));
        item.add(new Label("orderableElectronically", table.getOrderableElectronically()));

      }
    };
    add(tablesDataView);
    super.onInitialize();
  }

  @Override
  protected IPageable getPageable() {
    return tablesDataView;
  }

}
