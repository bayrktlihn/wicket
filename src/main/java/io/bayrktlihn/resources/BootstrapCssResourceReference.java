package io.bayrktlihn.resources;

import java.util.List;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

public class BootstrapCssResourceReference extends PackageResourceReference {

  private static final BootstrapCssResourceReference INSTANCE = new BootstrapCssResourceReference();

  public BootstrapCssResourceReference() {
    super(BootstrapCssResourceReference.class, "bootstrap.css");
  }

  public static BootstrapCssResourceReference get() {
    return INSTANCE;
  }

  @Override
  public List<HeaderItem> getDependencies() {
    List<HeaderItem> dependencies = super.getDependencies();
    dependencies.add(JavaScriptHeaderItem.forReference(BootstrapJsResourceReference.get()));
    return dependencies;
  }

}
