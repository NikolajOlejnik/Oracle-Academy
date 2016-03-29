package main.oracle.academy.fp.dao;

import java.util.Collection;

public interface Dao <Entity> {

    public void add(Entity instance);

    public Entity read (Long id);

    public void update(Entity object);

    public void delete(Long id);

    public Collection <Entity> getAll();
}
