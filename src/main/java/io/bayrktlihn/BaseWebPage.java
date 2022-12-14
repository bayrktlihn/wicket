package io.bayrktlihn;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import io.bayrktlihn.resources.BootstrapCssResourceReference;

public class BaseWebPage extends WebPage {

  public BaseWebPage(PageParameters parameters) {
    super(parameters);

    add(new Header("header"));
    add(new Footer("footer"));
  }

  @Override
  public void renderHead(IHeaderResponse response) {
    super.renderHead(response);
    response.render(CssHeaderItem.forReference(BootstrapCssResourceReference.get()));
  }



}
