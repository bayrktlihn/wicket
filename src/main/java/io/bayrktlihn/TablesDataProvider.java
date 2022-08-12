package io.bayrktlihn;

import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import io.bayrktlihn.entities.Table;
import io.bayrktlihn.services.ServiceRegistry;
import io.bayrktlihn.services.TableService;

public class TablesDataProvider extends SortableDataProvider<Table, Void> {

  @Override
  public Iterator<? extends Table> iterator(long first, long count) {
    TableService tableService = ServiceRegistry.get(TableService.class);
    return tableService.listAll().iterator();
  }

  @Override
  public long size() {
    TableService tableService = ServiceRegistry.get(TableService.class);
    return tableService.listAll().size();
  }

  @Override
  public IModel<Table> model(Table table) {
    return new EntityModel<>(table, TableService.class);
  }

}
