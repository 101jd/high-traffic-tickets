package org._jd.repository;

import org._jd.domain.interfaces.Entity;

import java.util.List;

public interface Repo {
    void save(Entity entity);

    Entity load(int id);

    Entity delete(Entity entity);

    List<Entity> loadAll();
}
