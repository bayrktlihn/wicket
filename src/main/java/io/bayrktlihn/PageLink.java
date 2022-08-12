package io.bayrktlihn;

import org.apache.wicket.Page;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.link.Link;

public class PageLink extends Link<Void> {


  private final Class<? extends Page> pageClass;

  public PageLink(String id, Class<? extends Page> pageClass) {
    super(id);
    this.pageClass = pageClass;
  }

  @Override
  public void onClick() {
    setResponsePage(pageClass);
  }

  @Override
  protected void onInitialize() {
    super.onInitialize();
    boolean notCurrentPageLink = !getPage().getClass().equals(pageClass);
    setEnabled(notCurrentPageLink);
    if (notCurrentPageLink) {
      add(new AttributeAppender("class", " active"));
    } else {
      add(new AttributeAppender("class", " disabled"));
    }
  }

}
