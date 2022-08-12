package io.bayrktlihn;

import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import io.bayrktlihn.entities.Article;
import io.bayrktlihn.services.ArticleService;
import io.bayrktlihn.services.ServiceRegistry;

public class ArticlesDataProvider extends SortableDataProvider<Article, Void> {

  @Override
  public Iterator<? extends Article> iterator(long first, long count) {
    ArticleService articleService = ServiceRegistry.get(ArticleService.class);
    return articleService.listAll().iterator();
  }

  @Override
  public long size() {
    ArticleService articleService = ServiceRegistry.get(ArticleService.class);
    return articleService.listAll().size();
  }

  @Override
  public IModel<Article> model(Article article) {
    return new EntityModel<>(article, ArticleService.class);
  }

}
