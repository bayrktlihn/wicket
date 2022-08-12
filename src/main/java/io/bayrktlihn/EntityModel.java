package io.bayrktlihn;

import org.apache.wicket.model.LoadableDetachableModel;
import com.google.gson.Gson;
import io.bayrktlihn.entities.BaseEntity;
import io.bayrktlihn.services.BaseService;
import io.bayrktlihn.services.ServiceRegistry;

public class EntityModel<T extends BaseEntity, S extends BaseService<T>> extends LoadableDetachableModel<T> {


  private Class<S> serviceClass;

  private Class<T> entityClass;
  private transient T entity;
  private Long id;
  private String newObjectSerialized;



  public EntityModel(Class<S> serviceClass) {
    this.serviceClass = serviceClass;
  }



  public EntityModel(T entity, Class<S> serviceClass) {

    this.serviceClass = serviceClass;
    this.entity = entity;
    entityClass = (Class<T>) entity.getClass();

    if (entity.getId() != null) {
      this.id = entity.getId();
    }
  }

  @Override
  public void setObject(T entity) {
    super.setObject(entity);
    this.entity = entity;
    entityClass = (Class<T>) entity.getClass();
  }



  @Override
  protected T load() {
    if (newObjectSerialized != null) {
      return new Gson().fromJson(newObjectSerialized, entityClass);
    }
    return ServiceRegistry.get(serviceClass).get(entity.getId());
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    if (entity == null) {
      return;
    }
    if (entity.getId() == null) {
      newObjectSerialized = new Gson().toJson(this.entity);
    }
    entity = null;
  }



}
