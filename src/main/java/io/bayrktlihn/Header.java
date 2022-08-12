package io.bayrktlihn;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class Header extends Panel {

  private WebMarkupContainer navbar = new WebMarkupContainer("navbar");

  private Link<Void> dasboardLink = new PageLink("dashboard", getApplication().getHomePage());
  private Link<Void> categoriesLink = new PageLink("categories", CategoriesPage.class);
  private Link<Void> articlesLink = new PageLink("articles", ArticlesPage.class);
  private Link<Void> tablesLink = new PageLink("tables", TablesPage.class);

  public Header(String id) {
    super(id);

    navbar.add(dasboardLink);
    navbar.add(categoriesLink);
    navbar.add(articlesLink);
    navbar.add(tablesLink);
    navbar.add(new ContextImage("brand", "sg-logo.png"));

    add(navbar);



  }

  @Override
  protected void onInitialize() {
    super.onInitialize();

  }



}
