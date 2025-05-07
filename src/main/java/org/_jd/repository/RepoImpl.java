package org._jd.repository;

import org._jd.domain.interfaces.Entity;

import java.util.ArrayList;
import java.util.List;

public class RepoImpl implements Repo {
    private final List<Entity> entities = new ArrayList<>();


    @Override
    public void save(Entity entity) {
        entities.add(entity);
    }

    @Override
    public Entity load(int id) {
        return entities.stream().filter(entity -> entity.getId() == id).findAny().orElse(null);
    }

    @Override
    public Entity delete(Entity entity) {
        entities.remove(entity);
        return entity;
    }

    @Override
    public List<Entity> loadAll() {
        return entities;
    }
}
